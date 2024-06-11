package com.mybankapp.MyBankApplication.util;

import com.mybankapp.MyBankApplication.dto.AccountDto;
import com.mybankapp.MyBankApplication.dto.TransactionDto;
import com.mybankapp.MyBankApplication.dto.UserDto;
import com.mybankapp.MyBankApplication.model.TransactionType;

import java.util.LinkedList;
import java.util.List;

public class Initializer {

    public static void main(String[] args) {


        TransactionDto.TransactionBuilder TransactionBuilder =
                new TransactionDto.TransactionBuilder(123456L, new AccountDto(56789L)).targetAccountId(null)
                    .transactionType(TransactionType.DEPOSIT).amount(19.0);

        System.out.println(TransactionBuilder.build());


        UserDto.UserBuilder UserBuilder = new UserDto.UserBuilder(123456L)
                .accounts(List.of(new AccountDto(123456L))).name("Jane Doe").username("jane_doe").password("123456");

        System.out.println(UserBuilder.build());
    }
}
