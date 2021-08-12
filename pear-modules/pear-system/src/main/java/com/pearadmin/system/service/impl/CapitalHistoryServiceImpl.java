package com.pearadmin.system.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.system.mapper.CapitalHistoryMapper;
import com.pearadmin.system.domain.CapitalHistory;
import com.pearadmin.system.service.ICapitalHistoryService;

/**
 * 交易记录Service业务层处理
 * 
 * @author wzh
 * @date 2021-08-09
 */
@Service
public class CapitalHistoryServiceImpl implements ICapitalHistoryService 
{
    @Autowired
    private CapitalHistoryMapper capitalHistoryMapper;

    /**
     * 查询交易记录
     * 
     * @param id 交易记录ID
     * @return 交易记录
     */
    @Override
    public CapitalHistory selectCapitalHistoryById(Long id)
    {
        return capitalHistoryMapper.selectCapitalHistoryById(id);
    }

    /**
     * 查询交易记录列表
     * 
     * @param capitalHistory 交易记录
     * @return 交易记录
     */
    @Override
    public List<CapitalHistory> selectCapitalHistoryList(CapitalHistory capitalHistory)
    {
        return capitalHistoryMapper.selectCapitalHistoryList(capitalHistory);
    }

    /**
     * 查询交易记录列表
     *
     * @param accountId 账户id
     * @return 交易记录
     */
    @Override
    public List<CapitalHistory> selectCapitalHistoryByAccountId(String accountId)
    {
        return capitalHistoryMapper.selectCapitalHistoryByAccountId(accountId);
    }

    /**
     * 查询交易记录
     * @param capitalHistory 交易记录
     * @param pageDomain
     * @return 交易记录 分页集合
     * */
    @Override
    public PageInfo<CapitalHistory> selectCapitalHistoryPage(CapitalHistory capitalHistory, PageDomain pageDomain)
    {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<CapitalHistory> data = capitalHistoryMapper.selectCapitalHistoryList(capitalHistory);
        return new PageInfo<>(data);
    }

    /**
     * 新增交易记录
     * 
     * @param capitalHistory 交易记录
     * @return 结果
     */

    @Override
    public int insertCapitalHistory(CapitalHistory capitalHistory)
    {
        return capitalHistoryMapper.insertCapitalHistory(capitalHistory);
    }

    /**
     * 修改交易记录
     * 
     * @param capitalHistory 交易记录
     * @return 结果
     */
    @Override
    public int updateCapitalHistory(CapitalHistory capitalHistory)
    {
        return capitalHistoryMapper.updateCapitalHistory(capitalHistory);
    }

    /**
     * 删除交易记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCapitalHistoryByIds(String[] ids)
    {
        return capitalHistoryMapper.deleteCapitalHistoryByIds(ids);
    }

    /**
     * 删除交易记录信息
     * 
     * @param id 交易记录ID
     * @return 结果
     */
    @Override
    public int deleteCapitalHistoryById(Long id)
    {
        return capitalHistoryMapper.deleteCapitalHistoryById(id);
    }
}
