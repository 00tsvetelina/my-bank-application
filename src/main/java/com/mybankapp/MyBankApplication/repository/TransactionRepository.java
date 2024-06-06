package com.mybankapp.MyBankApplication.repository;

import com.mybankapp.MyBankApplication.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findAllBySourceAccountIn(Long accountId);

}
