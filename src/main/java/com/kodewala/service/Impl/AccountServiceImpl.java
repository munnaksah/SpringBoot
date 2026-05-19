package com.kodewala.service.Impl;

import com.kodewala.dto.AccountDto;
import com.kodewala.entity.Account;
import com.kodewala.mapper.AccountMapper;
import com.kodewala.repository.AccountRepository;
import com.kodewala.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl  implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.maptoAccount(accountDto);

      Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

      Account account  =   accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not exits"));

        return  AccountMapper.maptoAccountDto(account);
    }

    @Override
    public AccountDto deposite(Long id, double amount) {
        Account account  =   accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not exits"));
       double total =  account.getBalance()+amount;
        account.setBalance(total);

      Account savedAccount =   accountRepository.save(account);

        return  AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdrawAmount(Long id, double amount) {

        Account account  =   accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not exits"));

        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient funds");


        }
        double total =  account.getBalance()-amount;
        account.setBalance(total);

     Account savedAccount =    accountRepository.save(account);


        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto>getAllAccounts() {
     List<Account>  accounts=  accountRepository.findAll();



        return accounts.stream().map((account)->AccountMapper.maptoAccountDto(account)).toList() ;
    }

    @Override
    public AccountDto deleteAccountById(Long id) {

        Account account  =   accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not exits"));


        accountRepository.deleteById(id);

        return null;
    }
}
