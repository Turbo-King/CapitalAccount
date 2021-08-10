package com.pearadmin.system.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.system.domain.CapitalNews;
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
import com.pearadmin.system.service.ICapitalNewsService;

import java.time.LocalDateTime;

/**
 * 新闻Controller
 *
 * @author wzh
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/capital/news")
public class CapitalNewsController extends BaseController
{
    private String prefix = "capital/news";

    @Autowired
    private ICapitalNewsService capitalNewsService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/capital/news/main','capital:news:main')")
    public ModelAndView main()
    {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询新闻列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/capital/news/data','capital:news:data')")
    public ResultTable list(@ModelAttribute CapitalNews capitalNews, PageDomain pageDomain)
    {
        PageInfo<CapitalNews> pageInfo = capitalNewsService.selectCapitalNewsPage(capitalNews,pageDomain);
        return pageTable(pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 新增新闻
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/capital/news/add','capital:news:add')")
    public ModelAndView add()
    {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增保存新闻
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/capital/news/add','capital:news:add')")
    public Result save(@RequestBody CapitalNews capitalNews)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        capitalNews.setCreateTime(LocalDateTime.now());
        capitalNews.setCreateBy(sysUser.getUserId());
        capitalNews.setCreateName(sysUser.getUsername());
        return decide(capitalNewsService.insertCapitalNews(capitalNews));
    }

    /**
     * 修改新闻
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/capital/news/edit','capital:news:edit')")
    public ModelAndView edit(Long id, ModelMap mmap)
    {
        CapitalNews capitalNews = capitalNewsService.selectCapitalNewsById(id);
        mmap.put("capitalNews", capitalNews);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改保存新闻
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/capital/news/edit','capital:news:edit')")
    public Result update(@RequestBody CapitalNews capitalNews)
    {
        SysUser sysUser = (SysUser)SecurityUtil.currentUserObj();
        capitalNews.setUpdateTime(LocalDateTime.now());
        capitalNews.setUpdateBy(sysUser.getUserId());
        capitalNews.setUpdateName(sysUser.getUsername());
        return decide(capitalNewsService.updateCapitalNews(capitalNews));
    }

    /**
     * 删除新闻
     */
    @ResponseBody
    @DeleteMapping( "/batchRemove")
    @PreAuthorize("hasPermission('/capital/news/remove','capital:news:remove')")
    public Result batchRemove(String ids)
    {
        return decide(capitalNewsService.deleteCapitalNewsByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/capital/news/remove','capital:news:remove')")
    public Result remove(@PathVariable("id") Long id)
    {
        return decide(capitalNewsService.deleteCapitalNewsById(id));
    }
}
