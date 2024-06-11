package com.mybankapp.MyBankApplication.service;

import com.mybankapp.MyBankApplication.model.User;
import com.mybankapp.MyBankApplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by account id
    public User getUserById(Long userId) {
        return userRepository.getUserById(userId)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                String.format("Cannot find user with id: %d", userId)
                        )
                );
    }

    // save user
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // edit user password
    @Transactional
    public User updatePassword(Long userId, String oldPassword, String newPassword) {
        User user = getUserById(userId);

        String password = user.getPassword().equals(oldPassword) ? newPassword : oldPassword;

        if (password.equals(oldPassword)) {
            throw new IllegalArgumentException(
                    "Cannot proceed with password change, incorrect previous password entry"
            );
        }

        user.setPassword(password);

        return userRepository.save(user);
    }

}
