package com.pearadmin.common.exception.capital.account;

/**
 * 账 户 余 额 不 足 异 常
 *
 * @author alin
 * @date   2021/8/12
 */
public class AccountInsufficientBalanceException extends AccountException {

    public AccountInsufficientBalanceException(String message) {
        super(message);
    }

}
