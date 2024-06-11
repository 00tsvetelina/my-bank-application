package com.mybankapp.MyBankApplication.dto;


import com.mybankapp.MyBankApplication.model.AccountStatus;
import com.mybankapp.MyBankApplication.model.AccountType;
import java.util.List;

public record AccountDto(Long id, UserDto user, AccountType type, List<TransactionDto> transactions,
                         Double balance, AccountStatus accountStatus) {

    public AccountDto(Long id) {
        this(id, null, null, null, null, null);
    }

    public AccountDto(Long id, UserDto user, AccountType type, List<TransactionDto> transactions,
                      Double balance, AccountStatus accountStatus) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.transactions = transactions;
        this.balance = balance;
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account [" +
                "id: " + id +
                ", user: " + user +
                ", status: " + accountStatus +
                "]";
    }
}
