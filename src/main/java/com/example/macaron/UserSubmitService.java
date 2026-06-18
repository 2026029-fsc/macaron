package com.example.macaron;

import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    // mypageに新規ユーザーの情報を追加する
    // public void userRegister(UserForm form) {
    // userSubmitRepository.mypage(new User(null, form.getMail(), form.getName(),
    // form.getPassword(), false));
    // }

    public Optional<User> findById(Long id) {
        return userSubmitRepository.findById(id);
    }

    // public boolean authenticate(String mail, String password) {
    // Optional<String> hash = userSubmitRepository.findPasswordHash(mail);
    // //値があればStringで帰ってくるからOptional<String>が戻り値の型
    // if (hash.isEmpty()) {//DBに値があるかどうか
    // return false;
    // }
    // return passwordEncoder.matches(password, hash.get());
    // //optionalに含まれるget()メソッド DBから値をとってくる
    // }

    // パスワードをハッシュ化して登録
    public void register(String name, String mail, String password) {
        String passwordhash = passwordEncoder.encode(password);
        userSubmitRepository.insertUser(name, mail, passwordhash);
    }
}
