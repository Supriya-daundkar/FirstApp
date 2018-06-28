package com.vsplc.FirstApp.dao;

import com.vsplc.FirstApp.model.UserProfile;

import java.util.List;

public interface UserProfileDao {

   List<UserProfile> findAll();
    
   UserProfile findByType(String type);
    
   UserProfile findById(int id);
}
