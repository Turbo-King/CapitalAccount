package com.pearadmin.common.domain;

import lombok.Getter;

/**
 * 交 易 类 型
 *
 * @author alin
 * @date 2021/8/12
 */
public enum DealType {

    /**
     * 存款
     */
    DEPOSIT(0, "存款"),

    /**
     * 取款
     */
    WITHDRAWAL(1, "取款"),

    /**
     * 转账
     */
    TRANSFER(2, "转账");

    /**
     * 类型代码
     */
    @Getter
    private int code;

    /**
     * 交易类型
     */
    @Getter
    private String type;

    DealType(int code, String type) {
        this.code = code;
        this.type = type;
    }

}
