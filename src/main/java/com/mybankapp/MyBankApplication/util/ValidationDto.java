package com.mybankapp.MyBankApplication.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ValidationDto {

    public static void validate(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
