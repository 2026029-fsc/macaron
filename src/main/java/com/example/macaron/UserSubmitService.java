package com.example.macaron;

import org.springframework.stereotype.Service;

@Service
public class UserSubmitService {
    private final UserSubmitRepository userSubmitRepository;

    public UserSubmitService(UserSubmitRepository userSubmintRepository){
        this.userSubmitRepository = userSubmintRepository;
    }
    
 //mypageに新規ユーザーの情報を追加する
    public void userRegister(UserForm form){
      userSubmitRepository.mypage(new UserForm(0,form.getMail(), form.getName(),form.getPassword(),false));
    }
}
