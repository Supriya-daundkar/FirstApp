package com.vsplc.FirstApp.service;

import java.util.List;

import com.vsplc.FirstApp.model.UserProfile;

 
 
public interface UserProfileService {
 
    UserProfile findById(int id);
 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
     
}
