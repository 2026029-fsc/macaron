package com.example.macaron;

import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserSubmitService {
  private final UserSubmitRepository userSubmitRepository;
  private final StoreReviewRepository storeReviewRepository;
  private final PasswordEncoder passwordEncoder;

  public UserSubmitService(UserSubmitRepository userSubmitRepository,  StoreReviewRepository storeReviewRepository , PasswordEncoder passwordEncoder){
    this.userSubmitRepository = userSubmitRepository;
    this.storeReviewRepository = storeReviewRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void post(Long id,StoreReviewForm form){
    storeReviewRepository.post(id, form.getComments(), form.getevaluation(),2);
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

     //どのサービスに書くかわからんけど、、、、
    //クーポン一覧を表示する コントローラーから渡されたfindCouponを実行
    public List<Store>findByIdCoupon(){
    return userSubmitRepository.findByIdCoupon();//リポジトリにfindByIdCouponをお願いする
    }
}
