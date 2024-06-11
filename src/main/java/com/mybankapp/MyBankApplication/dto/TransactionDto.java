package com.mybankapp.MyBankApplication.dto;

import com.mybankapp.MyBankApplication.model.TransactionStatus;
import com.mybankapp.MyBankApplication.model.TransactionType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.mybankapp.MyBankApplication.util.ValidationDto.validate;

public record TransactionDto(Long id, AccountDto sourceAccount, Long targetAccountId,
                             TransactionType transactionType, LocalDateTime timeOfInitialization,

                             LocalDateTime timeOfCompletion, Double amount, TransactionStatus status) {

        public TransactionDto {
            validate(sourceAccount != null, "sourceAccount cannot be null.");
            validate(transactionType != null, "transactionType cannot be null.");
            validate(amount != null && amount > 10.0, "amount cannot be null or less than 10 $.");
        }

        public static final class TransactionBuilder {

            private Long id;
            private AccountDto sourceAccount;
            private Long targetAccountId;
            private TransactionType transactionType;
            private LocalDateTime timeOfInitialization;
            private LocalDateTime timeOfCompletion;
            private Double amount;
            private TransactionStatus status;

            public TransactionBuilder(Long id, AccountDto sourceAccount) {
                this.id = id;
                this.sourceAccount = sourceAccount;
                this.timeOfInitialization = LocalDateTime.now();
                this.timeOfCompletion = LocalDateTime.now().plusSeconds(12);
                this.status = TransactionStatus.SUCCESSFUL;
            }

            public TransactionBuilder targetAccountId(Long targetAccountId) {
                if (targetAccountId != null) {
                    this.targetAccountId = targetAccountId;
                } else {
                    this.targetAccountId = sourceAccount.id();
                }

                return this;
            }

            public TransactionBuilder transactionType(TransactionType transactionType) {
                this.transactionType = transactionType;
                return this;
            }

            public TransactionBuilder amount(Double amount) {
                this.amount = amount;
                return this;
            }

            public TransactionDto build() {
                return new TransactionDto(id, sourceAccount, targetAccountId, transactionType,
                        timeOfInitialization, timeOfCompletion, amount, status);
            }
        }

    @Override
    public String toString() {
        return "Transaction [" +
                "id: " + id +
                ", source: " + sourceAccount +
                ", target: " + targetAccountId +
                ", type: " + transactionType +
                ", initialization: " + timeOfInitialization.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                ", completion: " + timeOfCompletion.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                ", amount: " + amount + "$" +
                ", status: " + status +
                ']';
    }
}

