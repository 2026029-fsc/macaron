package com.example.macaron;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserSubmitService {
    private final UserSubmitRepository userSubmitRepository;

    public UserSubmitService(UserSubmitRepository userSubmintRepository){
        this.userSubmitRepository = userSubmintRepository;
    }
    
 //mypageに新規ユーザーの情報を追加する
    public void userRegister(UserForm form){
      userSubmitRepository.mypage(new User(null,form.getMail(), form.getName(),form.getPassword(),false));
    }

    public Optional <User>findById(Long id){
     return userSubmitRepository.findById(id);   
    }

}
