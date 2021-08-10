package com.pearadmin.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.system.domain.CapitalHistory;

/**
 * 交易记录Mapper接口
 * 
 * @author wzh
 * @date 2021-08-09
 */
@Mapper
public interface CapitalHistoryMapper 
{
    /**
     * 查询交易记录
     * 
     * @param id 交易记录ID
     * @return 交易记录
     */
    public CapitalHistory selectCapitalHistoryById(Long id);

    /**
     * 查询交易记录列表
     * 
     * @param capitalHistory 交易记录
     * @return 交易记录集合
     */
    List<CapitalHistory> selectCapitalHistoryList(CapitalHistory capitalHistory);

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
     * 删除交易记录
     * 
     * @param id 交易记录ID
     * @return 结果
     */
    int deleteCapitalHistoryById(Long id);

    /**
     * 批量删除交易记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCapitalHistoryByIds(String[] ids);

}
