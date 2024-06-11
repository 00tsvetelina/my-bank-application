package com.mybankapp.MyBankApplication.dto;

import java.util.List;

import static com.mybankapp.MyBankApplication.util.ValidationDto.validate;

public record UserDto(Long id, String name, List<AccountDto> accounts, String username, String password) {

    public UserDto {
        validate(!name.isEmpty() && !name.isBlank(), "Please, enter a valid name.");
        accounts = List.copyOf(accounts);
        validate(!username.isEmpty() && !username.isBlank(), "Please, enter a valid username.");
        validate(!password.isEmpty() && !password.isBlank(), "Please, enter a valid password.");
    }

    public final static class UserBuilder {

        private Long id;
        private String name;
        private List<AccountDto> accounts;
        private String username;
        private String password;

        public UserBuilder(Long id) {
            this.id = id;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder accounts(List<AccountDto> accounts) {
            this.accounts = accounts;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDto build() {
            return new UserDto(id, name, accounts, username, password);
        }
    }

    @Override
    public String toString() {
        return "User [" +
                "id: " + id +
                ", name: " + name + '\'' +
                ", accounts: " + accounts +
                ", username: " + username + '\'' +
                ']';
    }
}
