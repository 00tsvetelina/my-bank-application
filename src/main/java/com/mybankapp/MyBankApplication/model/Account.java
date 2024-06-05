package com.mybankapp.MyBankApplication.model;

import java.util.Currency;
import java.util.List;

public class Account {

    private Long id;
    private AccountType type;
    private List<Transaction> transactions;
    private Double balance;
    private String accountStatus;
}
