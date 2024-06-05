package com.mybankapp.MyBankApplication.model;

import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private Account sourceAccount;
    private Account targetAccount;
    private TransactionType transactionType;
    private LocalDateTime timeOfInitialization;
    private LocalDateTime timeOfCompletion;
    private Double amount;
    private TransactionStatus status;

}
