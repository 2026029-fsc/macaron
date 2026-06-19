package com.example.macaron;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSubmitService {
    private final UserSubmitRepository userSubmitRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSubmitService(UserSubmitRepository userSubmintRepository, PasswordEncoder passwordEncoder) {
        this.userSubmitRepository = userSubmintRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findById(Long id) {
        return userSubmitRepository.findById(id);
    }

    // パスワードをハッシュ化して登録
    public void register(String name, String mail, String password) {
        String passwordhash = passwordEncoder.encode(password);
        userSubmitRepository.insertUser(name, mail, passwordhash);
    }
}
