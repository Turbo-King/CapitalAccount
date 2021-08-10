package com.pearadmin.system.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.system.domain.CapitalAccount;
import com.pearadmin.common.tools.string.Convert;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.common.tools.secure.SecurityUtil;
import com.pearadmin.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.pearadmin.system.service.ICapitalAccountService;

import java.time.LocalDateTime;

/**
 * 账户Controller
 *
 * @author wzh
 * @date 2021-08-10
 */
@RestController
@RequestMapping("/capital/account")
public class CapitalAccountController extends BaseController
{
    private String prefix = "capital/account";

    @Autowired
    private ICapitalAccountService capitalAccountService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/capital/account/main','capital:account:main')")
    public ModelAndView main()
    {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询账户列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/capital/account/data','capital:account:data')")
    public ResultTable list(@ModelAttribute CapitalAccount capitalAccount, PageDomain pageDomain)
    {
        PageInfo<CapitalAccount> pageInfo = capitalAccountService.selectCapitalAccountPage(capitalAccount,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 新增账户
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/capital/account/add','capital:account:add')")
    public ModelAndView add()
    {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增保存账户
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/capital/account/add','capital:account:add')")
    public Result save(@RequestBody CapitalAccount capitalAccount)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        capitalAccount.setCreateTime(LocalDateTime.now());
        capitalAccount.setCreateBy(sysUser.getUserId());
        capitalAccount.setCreateName(sysUser.getUsername());
        return decide(capitalAccountService.insertCapitalAccount(capitalAccount));
    }

    /**
     * 修改账户
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/capital/account/edit','capital:account:edit')")
    public ModelAndView edit(String accountId, ModelMap mmap)
    {
        CapitalAccount capitalAccount = capitalAccountService.selectCapitalAccountById(accountId);
        mmap.put("capitalAccount", capitalAccount);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改保存账户
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/capital/account/edit','capital:account:edit')")
    public Result update(@RequestBody CapitalAccount capitalAccount)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        capitalAccount.setUpdateTime(LocalDateTime.now());
        capitalAccount.setUpdateBy(sysUser.getUserId());
        capitalAccount.setUpdateName(sysUser.getUsername());
        return decide(capitalAccountService.updateCapitalAccount(capitalAccount));
    }

    /**
     * 删除账户
     */
    @ResponseBody
    @DeleteMapping( "/batchRemove")
    @PreAuthorize("hasPermission('/capital/account/remove','capital:account:remove')")
    public Result batchRemove(String ids)
    {
        return decide(capitalAccountService.deleteCapitalAccountByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/remove/{accountId}")
    @PreAuthorize("hasPermission('/capital/account/remove','capital:account:remove')")
    public Result remove(@PathVariable("accountId") String accountId)
    {
        return decide(capitalAccountService.deleteCapitalAccountById(accountId));
    }
}
