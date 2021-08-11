package com.pearadmin.system.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.system.domain.CapitalAccount;

/**
 * 账户Service接口
 * 
 * @author wzh
 * @date 2021-08-10
 */
public interface ICapitalAccountService 
{
    /**
     * 查询账户
     * 
     * @param accountId 账户ID
     * @return 账户
     */
    CapitalAccount selectCapitalAccountById(String accountId);

    /**
     * 查询账户
     *
     * @param userId 用户编号
     * @return 账户
     */
    CapitalAccount selectCapitalAccountByUserId(String userId);

    /**
    * 查询账户
     * @param ${classsName} 账户
     * @param pageDomain
     * @return 账户 分页集合
     * */
    PageInfo<CapitalAccount> selectCapitalAccountPage(CapitalAccount capitalAccount, PageDomain pageDomain);

    /**
     * 查询账户列表
     * 
     * @param capitalAccount 账户
     * @return 账户集合
     */
    List<CapitalAccount> selectCapitalAccountList(CapitalAccount capitalAccount);

    /**
     * 新增账户
     * 
     * @param capitalAccount 账户
     * @return 结果
     */
    int insertCapitalAccount(CapitalAccount capitalAccount);

    /**
     * 修改账户
     * 
     * @param capitalAccount 账户
     * @return 结果
     */
    int updateCapitalAccount(CapitalAccount capitalAccount);

    /**
     * 批量删除账户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCapitalAccountByIds(String[] ids);

    /**
     * 删除账户信息
     * 
     * @param accountId 账户ID
     * @return 结果
     */
    int deleteCapitalAccountById(String accountId);

}
