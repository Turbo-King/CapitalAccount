package com.pearadmin.system.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.system.domain.CapitalHistory;

/**
 * 交易记录Service接口
 * 
 * @author wzh
 * @date 2021-08-09
 */
public interface ICapitalHistoryService 
{
    /**
     * 查询交易记录
     * 
     * @param id 交易记录ID
     * @return 交易记录
     */
    CapitalHistory selectCapitalHistoryById(Long id);


    /**
    * 查询交易记录
     * @param ${classsName} 交易记录
     * @param pageDomain
     * @return 交易记录 分页集合
     * */
    PageInfo<CapitalHistory> selectCapitalHistoryPage(CapitalHistory capitalHistory, PageDomain pageDomain);

    /**
     * 查询交易记录列表
     * 
     * @param capitalHistory 交易记录
     * @return 交易记录集合
     */
    List<CapitalHistory> selectCapitalHistoryList(CapitalHistory capitalHistory);

    /**
     * 根据账户Id查询账户交易记录
     *
     * @param accountId 账户id
     * @return 交易记录集合
     */
    List<CapitalHistory> selectCapitalHistoryByAccountId(String accountId);

    /**
     * 新增交易记录
     * 
     * @param capitalHistory 交易记录
     * @return 结果
     */
    int insertCapitalHistory(CapitalHistory capitalHistory);

    /**
     * 修改交易记录
     * 
     * @param capitalHistory 交易记录
     * @return 结果
     */
    int updateCapitalHistory(CapitalHistory capitalHistory);

    /**
     * 批量删除交易记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCapitalHistoryByIds(String[] ids);

    /**
     * 删除交易记录信息
     * 
     * @param id 交易记录ID
     * @return 结果
     */
    int deleteCapitalHistoryById(Long id);

}
