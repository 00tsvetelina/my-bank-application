package com.mybankapp.MyBankApplication.repository;

import com.mybankapp.MyBankApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findAll();

    Optional<Account> getAccountById(Long accountId);



}
