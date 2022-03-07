package com.ncs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
//repository that extends JpaRepository
import com.ncs.model.Account;
public interface AccountRepository extends JpaRepository<Account, Integer>
{



}
