package com.pearadmin.system.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.system.mapper.CapitalNewsMapper;
import com.pearadmin.system.domain.CapitalNews;
import com.pearadmin.system.service.ICapitalNewsService;

/**
 * 新闻Service业务层处理
 * 
 * @author wzh
 * @date 2021-08-09
 */
@Service
public class CapitalNewsServiceImpl implements ICapitalNewsService 
{
    @Autowired
    private CapitalNewsMapper capitalNewsMapper;

    /**
     * 查询新闻
     * 
     * @param id 新闻ID
     * @return 新闻
     */
    @Override
    public CapitalNews selectCapitalNewsById(Long id)
    {
        return capitalNewsMapper.selectCapitalNewsById(id);
    }

    /**
     * 查询新闻列表
     * 
     * @param capitalNews 新闻
     * @return 新闻
     */
    @Override
    public List<CapitalNews> selectCapitalNewsList(CapitalNews capitalNews)
    {
        return capitalNewsMapper.selectCapitalNewsList(capitalNews);
    }

    /**
     * 查询新闻
     * @param capitalNews 新闻
     * @param pageDomain
     * @return 新闻 分页集合
     * */
    @Override
    public PageInfo<CapitalNews> selectCapitalNewsPage(CapitalNews capitalNews, PageDomain pageDomain)
    {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<CapitalNews> data = capitalNewsMapper.selectCapitalNewsList(capitalNews);
        return new PageInfo<>(data);
    }

    /**
     * 新增新闻
     * 
     * @param capitalNews 新闻
     * @return 结果
     */

    @Override
    public int insertCapitalNews(CapitalNews capitalNews)
    {
        return capitalNewsMapper.insertCapitalNews(capitalNews);
    }

    /**
     * 修改新闻
     * 
     * @param capitalNews 新闻
     * @return 结果
     */
    @Override
    public int updateCapitalNews(CapitalNews capitalNews)
    {
        return capitalNewsMapper.updateCapitalNews(capitalNews);
    }

    /**
     * 删除新闻对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCapitalNewsByIds(String[] ids)
    {
        return capitalNewsMapper.deleteCapitalNewsByIds(ids);
    }

    /**
     * 删除新闻信息
     * 
     * @param id 新闻ID
     * @return 结果
     */
    @Override
    public int deleteCapitalNewsById(Long id)
    {
        return capitalNewsMapper.deleteCapitalNewsById(id);
    }
}
