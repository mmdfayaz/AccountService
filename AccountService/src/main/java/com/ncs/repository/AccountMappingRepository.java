package com.ncs.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.ncs.model.AccountMapping;
public interface AccountMappingRepository extends JpaRepository<AccountMapping, Integer>
{
	//List<Account> findByAccountIdAndCustomerId(int acctId,int id);
}
