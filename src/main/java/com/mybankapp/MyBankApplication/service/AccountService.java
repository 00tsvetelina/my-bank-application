package com.mybankapp.MyBankApplication.service;

import com.mybankapp.MyBankApplication.model.Account;
import com.mybankapp.MyBankApplication.model.AccountStatus;
import com.mybankapp.MyBankApplication.model.Transaction;
import com.mybankapp.MyBankApplication.model.TransactionType;
import com.mybankapp.MyBankApplication.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    // get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // get account by id
    public Account getAccountById(Long accountId) {
        return accountRepository.getAccountById(accountId)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                String.format("Cannot find account with id: %d", accountId)
                        )
                );
    }

    // save account
    @Transactional
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    // update account status
    @Transactional
    public Account updateAccountStatus(Long accountId) {
        Account account = getAccountById(accountId);

        AccountStatus currentStatus = account.getAccountStatus();
        AccountStatus newStatus =
                currentStatus == AccountStatus.ACTIVE ? AccountStatus.INACTIVE : AccountStatus.ACTIVE;
        account.setAccountStatus(newStatus);

        return accountRepository.save(account);
    }

    // update account balance
    @Transactional
    public Account updateAccountBalance(Long accountId ,Transaction transaction) {
        Account account = getAccountById(accountId);
        Double balance = account.getBalance();
        TransactionType transactionType = transaction.getTransactionType();

        switch (transactionType) {
            case TRANSFER, WITHDRAWAL -> balance -= transaction.getAmount();
            case DEPOSIT -> balance += transaction.getAmount();
        }

        account.setBalance(balance);
        return accountRepository.save(account);

    }

}
