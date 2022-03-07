package com.ncs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.model.AccountMapping;
import com.ncs.model.AccountMappingList;
import com.ncs.service.AccountMappingService;
@RestController
public class AccountMappingController {

	//creating post mapping that post the account detail in the database
	@Autowired
	AccountMappingService accountMappingService;
	@PostMapping("/accountMapping") 
	private AccountMapping saveAccountMapping(@RequestBody AccountMapping accountMapping) { 
		accountMappingService.saveOrUpdate(accountMapping);
	  return accountMapping;
	  }
	@GetMapping("/accountMapping")
	private AccountMappingList getAllAccountMapping() 
	{
		AccountMappingList acctMapping =accountMappingService.getAllAccountMapping();
	return acctMapping;
	}
	//creating a get mapping that retrieves the detail of a specific account
	@GetMapping("/accountMapping/{accountMappingId}")
	private AccountMapping getAccountMapping(@PathVariable("accountMappingId") int accountMappingId) 
	{
	return accountMappingService.getAccountMappingById(accountMappingId);
	}
	@PostMapping("/accountMappingList") 
	private AccountMappingList saveAllAccountMapping(@RequestBody AccountMappingList accountMappingList) {
		accountMappingList.getObj().forEach(p->accountMappingService.saveOrUpdate(p));
	  return accountMappingList;
	  }
}
