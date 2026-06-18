package com.example.macaron;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserSubmitService {
    private final UserSubmitRepository userSubmitRepository;
    private final PasswordEncoder passwordEncoder;

    // @Autowired
    public UserSubmitService(UserSubmitRepository userSubmintRepository, PasswordEncoder passwordEncoder) {
        this.userSubmitRepository = userSubmintRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findById(Long id) {
        return userSubmitRepository.findById(id);
    }


    // ハッシュ化して登録したい。。。
    public void register(String name, String mail, String password) {
        String passwordhash = passwordEncoder.encode(password);
        userSubmitRepository.insertUser(name, mail, passwordhash);
    }

    public boolean authenticate(String mail, String rawPassword) {
    // メールアドレスからユーザーを検索
        Optional<User> userOpt = userSubmitRepository.findByMail(mail);
        if (userOpt.isEmpty()) {
            return false; // ユーザーが存在しない
        }

        User user = userOpt.get();
    // 入力された生パスワードと、DBのハッシュ化パスワードを比較
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    public Optional<User> findByMail(String mail) {
        return userSubmitRepository.findByMail(mail); 
    }
}


