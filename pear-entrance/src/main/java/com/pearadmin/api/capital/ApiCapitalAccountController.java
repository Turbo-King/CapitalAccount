package com.pearadmin.api.capital;

import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.system.domain.CapitalAccount;
import com.pearadmin.system.service.ICapitalAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 账户Controller
 *
 * @author wzh
 * @date 2021-08-09
 */
@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/api/account")
public class ApiCapitalAccountController extends BaseController {

    private final ICapitalAccountService capitalAccountService;

    public ApiCapitalAccountController(ICapitalAccountService capitalAccountService) {
        this.capitalAccountService = capitalAccountService;
    }

    /**
     * 存款
     * @param money 金额
     * @return Result
     */
    @PostMapping("deposit")
    @ApiOperation(value = "存款", tags = "1.金融系统")
    public Result deposit(String userId, String money) {
        System.out.println("存款");
        try {
            BigDecimal realMoney = new BigDecimal(money);

            CapitalAccount account = capitalAccountService.selectCapitalAccountByUserId(userId);

            // 添加金额
            realMoney = account.getMoney().add(realMoney);
            account.setMoney(realMoney);

            // TODO: 2021/8/10 交易记录 - 事务

            return decide(capitalAccountService.updateCapitalAccount(account), "支付成功", "支付失败");
        } catch (NullPointerException e) {
            e.printStackTrace();
            return failure("不存在该账户");
        } catch (Exception e) {
            e.printStackTrace();
            return failure();
        }
    }

    /**
     * 取款
     * @param money 金额
     * @return Result
     */
    @PostMapping("withdrawal")
    @ApiOperation(value = "取款", tags = "1.金融系统")
    public Result withdrawal(String userId, String money) {
        System.out.println("取款");
        try {
            BigDecimal realMoney = parseMoney(money);

            CapitalAccount account = capitalAccountService.selectCapitalAccountByUserId(userId);

            // 减少金额
            realMoney = account.getMoney().subtract(realMoney);
            if (realMoney.compareTo(new BigDecimal(0)) < 0) {
                return failure("账户余额不足");
            }

            account.setMoney(realMoney);

            // TODO: 2021/8/10 交易记录 - 事务

            return decide(capitalAccountService.updateCapitalAccount(account));
        } catch (NullPointerException e) {
            return failure("不存在该账户");
        } catch (Exception e) {
            return failure("金额错误");
        }
    }

//    /**
//     * 处理基础业务(存款、取款、转账等操作)
//     */
//    @ResponseBody
//    @PutMapping("business")
//    public Result business(Integer type, String count, Double money, String byCount) {
//        int success = 0;
//        if (type == 0) {
//            //todo 存款
//        } else if (type == 1) {
//            //todo 取款
//        } else if (type == 2) {
//            //todo 转账
//        }
//        return success == 1 ? success() : failure();
//    }

//    /**
//     * 修改保存账户
//     */
//    public int update(@RequestBody CapitalAccount capitalAccount) {
//        SysUser sysUser = (SysUser) SecurityUtil.currentUserObj();
//        return capitalAccountService.updateCapitalAccount(capitalAccount);
//    }

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

    private BigDecimal parseMoney(String money) {
        // TODO: 2021/8/11 throw 金额错误
        return new BigDecimal(money);
    }

}
