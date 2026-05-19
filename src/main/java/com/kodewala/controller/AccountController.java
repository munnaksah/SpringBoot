package com.kodewala.controller;

import com.kodewala.dto.AccountDto;
import com.kodewala.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account/api")
public class AccountController {

    @Autowired
    private IAccountService accountService;


    // add Account or create account


    @PostMapping("/account")
    public ResponseEntity<AccountDto> addAccount( @RequestBody AccountDto accountDto){

      AccountDto  addAcc=  accountService.createAccount(accountDto);
        return   new ResponseEntity<>(addAcc, HttpStatus.CREATED);

    }


    // getAccountById

@GetMapping("/account/{id}")
    public ResponseEntity<AccountDto >getAccountById( @PathVariable Long id){
      AccountDto accountDto =  accountService.getAccountById(id);

        return   new ResponseEntity<>(accountDto, HttpStatus.OK);

    }



    //  deposite amount

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> deposite(@PathVariable Long id, @RequestBody Map<String,Double> request){

        Double amount = request.get("amount");
        AccountDto  accountDto= accountService.deposite(id, amount);

        return new ResponseEntity<>(accountDto, HttpStatus.OK);





        }

    //withdraw Amount

    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto> withdrawAmount (@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto  accountDto= accountService.withdrawAmount(id, amount);


        return new  ResponseEntity<>(accountDto, HttpStatus.OK);



    }


    // getAllAccount  RestApi

@GetMapping("/accounts")
    public  ResponseEntity<List<AccountDto>>getAllAccounts(){

        List<AccountDto> getAll =   accountService.getAllAccounts();

        return new ResponseEntity<>(getAll, HttpStatus.OK);

    }


    // deleteAccountById

@DeleteMapping("/{id}")
    public ResponseEntity<String>deleteAccountById(@PathVariable Long id){

         accountService.deleteAccountById(id);

        return new ResponseEntity<>("Deleted Succesfully",HttpStatus.OK);

    }



}
