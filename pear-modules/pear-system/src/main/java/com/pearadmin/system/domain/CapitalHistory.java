package com.pearadmin.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 交易记录对象 capital_history
 *
 * @author wzh
 * @date 2021-08-09
 */
@Data
public class CapitalHistory extends BaseDomain {
    private static final long serialVersionUID = 1L;

    /**
     * 交易流水号
     */
    private Long id;

    /**
     * 交易账户
     */
    private String accountId;

    /**
     * 交易类型（0-存款1-取款2-转账）
     */
    private Long type;

    /**
     * 交易金额
     */
    private Double money;

    /**
     * 转账接受账户号
     */
    private String byAccount;

}
