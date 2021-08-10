package com.pearadmin.system.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.system.domain.CapitalHistory;
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
import com.pearadmin.system.service.ICapitalHistoryService;

import java.time.LocalDateTime;

/**
 * 交易记录Controller
 *
 * @author wzh
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/capital/history")
public class CapitalHistoryController extends BaseController
{
    private String prefix = "capital/history";

    @Autowired
    private ICapitalHistoryService capitalHistoryService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/capital/history/main','capital:history:main')")
    public ModelAndView main()
    {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询交易记录列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/capital/history/data','capital:history:data')")
    public ResultTable list(@ModelAttribute CapitalHistory capitalHistory, PageDomain pageDomain)
    {
        PageInfo<CapitalHistory> pageInfo = capitalHistoryService.selectCapitalHistoryPage(capitalHistory,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 新增交易记录
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/capital/history/add','capital:history:add')")
    public ModelAndView add()
    {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增保存交易记录
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/capital/history/add','capital:history:add')")
    public Result save(@RequestBody CapitalHistory capitalHistory)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        capitalHistory.setCreateTime(LocalDateTime.now());
        capitalHistory.setCreateBy(sysUser.getUserId());
        capitalHistory.setCreateName(sysUser.getUsername());
        return decide(capitalHistoryService.insertCapitalHistory(capitalHistory));
    }

    /**
     * 修改交易记录
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/capital/history/edit','capital:history:edit')")
    public ModelAndView edit(Long id, ModelMap mmap)
    {
        CapitalHistory capitalHistory = capitalHistoryService.selectCapitalHistoryById(id);
        mmap.put("capitalHistory", capitalHistory);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改保存交易记录
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/capital/history/edit','capital:history:edit')")
    public Result update(@RequestBody CapitalHistory capitalHistory)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        capitalHistory.setUpdateTime(LocalDateTime.now());
        capitalHistory.setUpdateBy(sysUser.getUserId());
        capitalHistory.setUpdateName(sysUser.getUsername());
        return decide(capitalHistoryService.updateCapitalHistory(capitalHistory));
    }

    /**
     * 删除交易记录
     */
    @ResponseBody
    @DeleteMapping( "/batchRemove")
    @PreAuthorize("hasPermission('/capital/history/remove','capital:history:remove')")
    public Result batchRemove(String ids)
    {
        return decide(capitalHistoryService.deleteCapitalHistoryByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/capital/history/remove','capital:history:remove')")
    public Result remove(@PathVariable("id") Long id)
    {
        return decide(capitalHistoryService.deleteCapitalHistoryById(id));
    }
}
