package com.example.macaron;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



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


    // ハッシュ化して登録したい。。。
    public void register(String name, String mail, String password) {
        String passwordhash = passwordEncoder.encode(password);
        userSubmitRepository.insertUser(name, mail, passwordhash);
    }

     //どのサービスに書くかわからんけど、、、、
    //クーポン一覧を表示する コントローラーから渡されたfindCouponを実行
    public List<Store>findByIdCoupon(){
    return userSubmitRepository.findByIdCoupon();//リポジトリにfindByIdCouponをお願いする
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


