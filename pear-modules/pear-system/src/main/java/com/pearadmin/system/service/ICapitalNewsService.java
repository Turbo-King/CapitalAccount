package com.pearadmin.system.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.system.domain.CapitalNews;

/**
 * 新闻Service接口
 * 
 * @author wzh
 * @date 2021-08-09
 */
public interface ICapitalNewsService 
{
    /**
     * 查询新闻
     * 
     * @param id 新闻ID
     * @return 新闻
     */
    CapitalNews selectCapitalNewsById(Long id);


    /**
    * 查询新闻
     * @param ${classsName} 新闻
     * @param pageDomain
     * @return 新闻 分页集合
     * */
    PageInfo<CapitalNews> selectCapitalNewsPage(CapitalNews capitalNews, PageDomain pageDomain);

    /**
     * 查询新闻列表
     * 
     * @param capitalNews 新闻
     * @return 新闻集合
     */
    List<CapitalNews> selectCapitalNewsList(CapitalNews capitalNews);

    /**
     * 新增新闻
     * 
     * @param capitalNews 新闻
     * @return 结果
     */
    int insertCapitalNews(CapitalNews capitalNews);

    /**
     * 修改新闻
     * 
     * @param capitalNews 新闻
     * @return 结果
     */
    int updateCapitalNews(CapitalNews capitalNews);

    /**
     * 批量删除新闻
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCapitalNewsByIds(String[] ids);

    /**
     * 删除新闻信息
     * 
     * @param id 新闻ID
     * @return 结果
     */
    int deleteCapitalNewsById(Long id);

}
