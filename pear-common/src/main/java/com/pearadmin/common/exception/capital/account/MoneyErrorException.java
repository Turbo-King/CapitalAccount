package com.pearadmin.common.exception.capital.account;

/**
 * 金 额 错 误 异 常
 *
 * @author alin
 * @date 2021/8/12
 */
public class MoneyErrorException extends NullPointerException {

    public MoneyErrorException(String s) {
        super(s);
    }

}
