package com.ncs.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.model.Account;
import com.ncs.repository.AccountMappingRepository;
import com.ncs.repository.AccountRepository;
//defining the business logic
@Service
public class AccountService 
{

@Autowired
AccountRepository accountRepository;
@Autowired
AccountMappingRepository accountMappingRepository;

//getting all account record by using the method findaAll() of JpaRepository
@Transactional(readOnly = true)
public List<Account> getAllAccount() 
{
List<Account> account = new ArrayList<Account>();
accountRepository.findAll().forEach(account1 -> account.add(account1));
return account;
}
//getting a specific record by using the method findById() of JpaRepository
@Transactional(readOnly = true)
public Account getAccountById(int id) 
{
return accountRepository.findById(id).get();
}
//saving a specific record by using the method save() of JpaRepository
@Transactional(propagation = Propagation.REQUIRED)
public Account saveOrUpdate(Account account) 
{
	return accountRepository.save(account);
}
//deleting a specific record by using the method deleteById() of JpaRepository
public void delete(int id) 
{
accountRepository.deleteById(id);
}
}