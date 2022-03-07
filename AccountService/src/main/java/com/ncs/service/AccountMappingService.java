package com.ncs.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.model.AccountMapping;
import com.ncs.model.AccountMappingList;
import com.ncs.repository.AccountMappingRepository;
//defining the business logic
@Service
public class AccountMappingService 
{
@Autowired
AccountMappingRepository accountMappingRepository;

//getting a specific record by using the method findById() of JpaRepository
	/*
	 * public List<Account> getAccountListById(int acct,int id) { return
	 * accountMappingRepository.findByAccountIdAndCustomerId(acct,id); }
	 */
//saving a specific record by using the method save() of JpaRepository
@Transactional(propagation = Propagation.REQUIRED)
public void saveOrUpdate(AccountMapping account) 
{
	accountMappingRepository.save(account);
}
//deleting a specific record by using the method deleteById() of JpaRepository
public void delete(int id) 
{
	accountMappingRepository.deleteById(id);
}
public AccountMappingList getAllAccountMapping() {
	AccountMappingList accountMappingObj = new AccountMappingList();
	List<AccountMapping> accountMapping = new ArrayList<AccountMapping>();
	accountMappingRepository.findAll().forEach(account1 -> accountMapping.add(account1));
	accountMappingObj.setObj(accountMapping);
	return accountMappingObj;
}
public AccountMapping getAccountMappingById(int accountMappingId) {
	return accountMappingRepository.findById(accountMappingId).get();
}

}