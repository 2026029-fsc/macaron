package com.example.macaron;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSubmitService {
    private final UserSubmitRepository userSubmitRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserSubmitService(UserSubmitRepository userSubmintRepository) {
        this.userSubmitRepository = userSubmintRepository;
    }

    // mypageに新規ユーザーの情報を追加する
    public void userRegister(UserForm form) {
        userSubmitRepository.mypage(new User(null, form.getMail(), form.getName(), form.getPassword(), false));
    }

    public Optional<User> findById(Long id) {
        return userSubmitRepository.findById(id);
    }

    // パスワードをハッシュ化する
    public boolean authenticate(String mail, String password) {
        Optional<User> hash = userSubmitRepository.findPasswordHash(mail);
        if (hash.isEmpty()) {
            return false;
        }
        return passwordEncoder.matches(password, hash.get());
    }

}
