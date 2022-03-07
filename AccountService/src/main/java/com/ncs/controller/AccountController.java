package com.ncs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.model.Account;
import com.ncs.service.AccountService;
//mark class as Controller
@RestController
public class AccountController 
{
//autowire the AccountService class
@Autowired
AccountService accountService;

//creating a get mapping that retrieves all the account detail from the database 
@GetMapping("/account")
private List<Account> getAllAccount() 
{
return accountService.getAllAccount();
}
//creating a get mapping that retrieves the detail of a specific account
@GetMapping("/account/{accountid}")
private Account getAccount(@PathVariable("accountid") int accountid) 
{
return accountService.getAccountById(accountid);
}
//creating a delete mapping that deletes a specified account
@DeleteMapping("/account/{accountid}")
private void deleteAccount(@PathVariable("accountid") int accountid) 
{
accountService.delete(accountid);
}
//creating post mapping that post the account detail in the database
@PostMapping("/account")
private Account saveAccount(@RequestBody Account account) 
{
accountService.saveOrUpdate(account);
return account;
}
//creating put mapping that updates the Account detail 
@PutMapping("/account")
private Account update(@RequestBody Account account) 
{
accountService.saveOrUpdate(account);
return account;
}


}
