package com.pearadmin.api.capital;

import com.pearadmin.common.constant.AccountConstant;
import com.pearadmin.common.exception.capital.account.AccountException;
import com.pearadmin.common.exception.capital.account.AccountInsufficientBalanceException;
import com.pearadmin.common.exception.capital.account.AccountNotFoundException;
import com.pearadmin.common.exception.capital.account.MoneyErrorException;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.system.domain.CapitalAccount;
import com.pearadmin.system.domain.SysUser;
import com.pearadmin.system.service.ICapitalAccountService;
import com.pearadmin.system.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 账户Controller
 *
 * @author alin
 * @date   2021-08-11
 */
@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/api/account")
public class ApiCapitalAccountController extends BaseController {

    // 账户服务
    private final ICapitalAccountService capitalAccountService;

    // 用户服务
    private final ISysUserService sysUserService;

    public ApiCapitalAccountController(ICapitalAccountService capitalAccountService, ISysUserService sysUserService) {
        this.capitalAccountService = capitalAccountService;
        this.sysUserService = sysUserService;
    }

    /**
     * 存款
     *
     * @param userId 用户编号
     * @param money 金额
     * @return Result
     */
    @PostMapping("deposit")
    @ApiOperation(value = "存款", tags = "1.金融系统")
    public Result deposit(String userId, String money) {
        System.out.println("存款");
        try {
            boolean success = setMoney(userId, money, true);

            // TODO: 2021/8/10 交易记录 - 事务

            return pay(success);
        } catch (Exception e) {
            return failure(e.getMessage());
        }
    }

    /**
     * 取款
     *
     * @param userId 用户编号
     * @param money 金额
     * @return Result
     */
    @PostMapping("withdrawal")
    @ApiOperation(value = "取款", tags = "1.金融系统")
    public Result withdrawal(String userId, String money) {
        System.out.println("取款");
        try {
            boolean success = setMoney(userId, money, false);

            // TODO: 2021/8/10 交易记录 - 事务

            return pay(success);
        } catch (Exception e) {
            return failure(e.getMessage());
        }
    }
    
    /**
     * 转账
     *
     * @param curUserId 当前用户编号
     * @param transferUsername 转账用户编号
     * @param money 金额
     * @return Result
     */
    @PostMapping("transfer")
    @ApiOperation(value = "转账", tags = "1.金融系统")
    public Result transfer(String curUserId, String transferUsername, String money) {
        System.out.println("转账");
        try {
            SysUser user = sysUserService.getByUsername(transferUsername);
            if (user == null) throw new AccountNotFoundException(AccountConstant.TRANSFER_ACCOUNT_NOT_FOUND);

            boolean success = setMoney(curUserId, money, false)
                           && setMoney(user.getUserId(), money, true);

            // TODO: 2021/8/10 交易记录 - 事务

            return pay(success);
        } catch (Exception e) {
            return failure(e.getMessage());
        }
    }

    /**
     * 设置账户余额
     * @param userId 用户编号
     * @param money 金额
     * @param add 是否增加
     * @return boolean
     */
    private boolean setMoney(String userId, String money, boolean add) throws MoneyErrorException, AccountException {
        // 验证数据有效性
        if (money == null)  throw new MoneyErrorException(AccountConstant.MONEY_ERROR);
        if (userId == null) throw new AccountException(AccountConstant.ACCOUNT_NOT_FOUND);

        BigDecimal realMoney = new BigDecimal(money);
        CapitalAccount account = capitalAccountService.selectCapitalAccountByUserId(userId);

        // 验证用户是否为空
        if (account == null) throw new AccountException(AccountConstant.ACCOUNT_NOT_FOUND);

        // 进行余额增加或减少
        realMoney = add ? account.getMoney().add(realMoney) : account.getMoney().subtract(realMoney);

        // 验证余额
        if (realMoney.compareTo(new BigDecimal(0)) < 0) throw new AccountInsufficientBalanceException(AccountConstant.ACCOUNT_INSUFFICIENT_BALANCE);

        // 设置余额
        account.setMoney(realMoney);

        return capitalAccountService.updateCapitalAccount(account) > 0;
    }

    /**
     * 查询账户
     * @param id 用户编号
     * @return 账户实体类
     */
    @GetMapping("detail")
    public Result detail(String id) {
        CapitalAccount account = capitalAccountService.selectCapitalAccountById(id);
        if (account == null) {
            return failure("账户不存在");
        }
        return success(account);
    }

    private Result pay(Boolean b) {
        return decide(b, AccountConstant.PAY_SUCCESS, AccountConstant.PAY_FAILURE);
    }

}
