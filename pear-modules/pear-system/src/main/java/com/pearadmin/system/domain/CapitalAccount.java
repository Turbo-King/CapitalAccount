package com.pearadmin.system.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 账户对象 capital_account
 * 
 * @author wzh
 * @date 2021-08-10
 */
@Data
public class CapitalAccount extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 账户id */
    private String accountId;

    /** 用户id */
    private String userId;

    /** 账户金额 */
    private BigDecimal money;

}
