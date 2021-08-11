package com.pearadmin.api.capital;

import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.system.domain.SysUser;
import com.pearadmin.system.service.ISysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Describe: 用户控制器
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 */
@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/api/capital/user")
public class ApiSysUserController extends BaseController {

    /**
     * Describe: 用户模块服务
     */
    @Resource
    private ISysUserService sysUserService;

    /**
     * Describe: 获取用户详细信息
     * Param id
     * Return 用户详细信息
     */
    @GetMapping("info")
    public Result info(String id) {
        SysUser sysUser = sysUserService.getById(id);
        return success(sysUser);
    }

    /**
     * Describe: 修改用户信息
     * Param id
     * Return 用户详细信息
     */
    @PostMapping("update")
    public Result update(SysUser sysUser) {
        return Result.decide(sysUserService.update(sysUser));
    }

}
