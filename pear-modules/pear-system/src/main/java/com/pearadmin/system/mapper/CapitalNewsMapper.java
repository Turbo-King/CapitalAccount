package com.pearadmin.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.system.domain.CapitalNews;

/**
 * 新闻Mapper接口
 * 
 * @author wzh
 * @date 2021-08-09
 */
@Mapper
public interface CapitalNewsMapper 
{
    /**
     * 查询新闻
     * 
     * @param id 新闻ID
     * @return 新闻
     */
    public CapitalNews selectCapitalNewsById(Long id);

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
     * 删除新闻
     * 
     * @param id 新闻ID
     * @return 结果
     */
    int deleteCapitalNewsById(Long id);

    /**
     * 批量删除新闻
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCapitalNewsByIds(String[] ids);

}
