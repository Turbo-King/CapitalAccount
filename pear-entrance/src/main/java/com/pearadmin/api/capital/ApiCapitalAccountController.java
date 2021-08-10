//package com.pearadmin.api.capital;
//
//import com.pearadmin.common.tools.secure.SecurityUtil;
//import com.pearadmin.common.web.base.BaseController;
//import com.pearadmin.common.web.domain.response.Result;
//import com.pearadmin.system.domain.SysUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * 账户Controller
// *
// * @author wzh
// * @date 2021-08-09
// */
//@RestController
//@CrossOrigin //解决跨域问题
//@RequestMapping("/api/capital/account")
//public class ApiCapitalAccountController extends BaseController {
//    private String prefix = "capital/account";
//
//    @Autowired
//    private ICapitalAccountService capitalAccountService;
//
//
//    /**
//     * 处理基础业务(存款、取款、转账等操作)
//     */
//    @ResponseBody
//    @PutMapping("/business")
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
//
//    /**
//     * 修改保存账户
//     */
//    public int update(@RequestBody CapitalAccount capitalAccount) {
//        SysUser sysUser = (SysUser) SecurityUtil.currentUserObj();
//        return capitalAccountService.updateCapitalAccount(capitalAccount);
//    }
//
//    /**
//     * 查询账户
//     */
//    public CapitalAccount details(String id) {
//        CapitalAccount capitalAccount = capitalAccountService.selectCapitalAccountById(id);
//        return capitalAccount;
//    }
//}
