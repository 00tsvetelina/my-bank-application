package com.mybankapp.MyBankApplication.service;

import com.mybankapp.MyBankApplication.model.Transaction;
import com.mybankapp.MyBankApplication.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    // get transactions by account id
    public List<Transaction> getAllTransactionsByAccountId(Long accountId) {
        return transactionRepository.findAllBySourceAccountIn(accountId);
    }

    // create transaction
    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
