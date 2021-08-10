package com.pearadmin.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.system.domain.CapitalAccount;

/**
 * 账户Mapper接口
 * 
 * @author wzh
 * @date 2021-08-10
 */
@Mapper
public interface CapitalAccountMapper 
{
    /**
     * 查询账户
     * 
     * @param accountId 账户ID
     * @return 账户
     */
    public CapitalAccount selectCapitalAccountById(String accountId);

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
     * 删除账户
     * 
     * @param accountId 账户ID
     * @return 结果
     */
    int deleteCapitalAccountById(String accountId);

    /**
     * 批量删除账户
     * 
     * @param accountIds 需要删除的数据ID
     * @return 结果
     */
    int deleteCapitalAccountByIds(String[] accountIds);

}
