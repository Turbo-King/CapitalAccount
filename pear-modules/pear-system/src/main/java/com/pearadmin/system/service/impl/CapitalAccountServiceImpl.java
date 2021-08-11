package com.pearadmin.system.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.system.mapper.CapitalAccountMapper;
import com.pearadmin.system.domain.CapitalAccount;
import com.pearadmin.system.service.ICapitalAccountService;

/**
 * 账户Service业务层处理
 * 
 * @author wzh
 * @date 2021-08-10
 */
@Service
public class CapitalAccountServiceImpl implements ICapitalAccountService 
{
    @Autowired
    private CapitalAccountMapper capitalAccountMapper;

    /**
     * 查询账户
     * 
     * @param accountId 账户ID
     * @return 账户
     */
    @Override
    public CapitalAccount selectCapitalAccountById(String accountId)
    {
        return capitalAccountMapper.selectCapitalAccountById(accountId);
    }

    /**
     * 查询账户
     *
     * @param userId 用户编号
     * @return 账户
     */
    @Override
    public CapitalAccount selectCapitalAccountByUserId(String userId)
    {
        return capitalAccountMapper.selectCapitalAccountByUserId(userId);
    }

    /**
     * 查询账户列表
     * 
     * @param capitalAccount 账户
     * @return 账户
     */
    @Override
    public List<CapitalAccount> selectCapitalAccountList(CapitalAccount capitalAccount)
    {
        return capitalAccountMapper.selectCapitalAccountList(capitalAccount);
    }

    /**
     * 查询账户
     * @param capitalAccount 账户
     * @param pageDomain
     * @return 账户 分页集合
     * */
    @Override
    public PageInfo<CapitalAccount> selectCapitalAccountPage(CapitalAccount capitalAccount, PageDomain pageDomain)
    {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        List<CapitalAccount> data = capitalAccountMapper.selectCapitalAccountList(capitalAccount);
        return new PageInfo<>(data);
    }

    /**
     * 新增账户
     * 
     * @param capitalAccount 账户
     * @return 结果
     */

    @Override
    public int insertCapitalAccount(CapitalAccount capitalAccount)
    {
        return capitalAccountMapper.insertCapitalAccount(capitalAccount);
    }

    /**
     * 修改账户
     * 
     * @param capitalAccount 账户
     * @return 结果
     */
    @Override
    public int updateCapitalAccount(CapitalAccount capitalAccount)
    {
        return capitalAccountMapper.updateCapitalAccount(capitalAccount);
    }

    /**
     * 删除账户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCapitalAccountByIds(String[] ids)
    {
        return capitalAccountMapper.deleteCapitalAccountByIds(ids);
    }

    /**
     * 删除账户信息
     * 
     * @param accountId 账户ID
     * @return 结果
     */
    @Override
    public int deleteCapitalAccountById(String accountId)
    {
        return capitalAccountMapper.deleteCapitalAccountById(accountId);
    }
}
