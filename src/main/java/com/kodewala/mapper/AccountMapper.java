package com.kodewala.mapper;

import com.kodewala.dto.AccountDto;
import com.kodewala.entity.Account;

public class AccountMapper {

    public static Account maptoAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance() );
        return account;
    }


    public  static AccountDto maptoAccountDto(Account account) {
        AccountDto  accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );

        return accountDto;

    }
}
