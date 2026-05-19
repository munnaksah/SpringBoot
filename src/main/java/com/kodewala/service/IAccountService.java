package com.kodewala.service;

import com.kodewala.dto.AccountDto;

import java.util.List;

public interface IAccountService {

    public AccountDto createAccount(AccountDto  accountDto);


    public AccountDto getAccountById(Long id);

    public AccountDto  deposite(Long id , double amount);


    public  AccountDto withdrawAmount(Long id , double amount);


    public List<AccountDto> getAllAccounts();


    public AccountDto deleteAccountById(Long id);
}
