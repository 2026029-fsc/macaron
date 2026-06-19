package com.example.macaron;

import org.springframework.stereotype.Service;

@Service
public class UserSubmitService {

  private final StoreReviewRepository storeReviewRepository;

  public UserSubmitService(StoreReviewRepository storeReviewRepository){
    this.storeReviewRepository = storeReviewRepository;
  }

  public void post(Long id,StoreReviewForm form){
    storeReviewRepository.post(id, form.getComments(), form.getevaluation(),2);
  }
}
