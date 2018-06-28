package com.vsplc.FirstApp.dao;

import java.util.List;

import com.vsplc.FirstApp.model.User;
 
public interface UserDao {
 
    User findById(int id);
     
    User findBySSO(String sso);
     
    void save(User user);
     
    void deleteBySSO(String sso);
     
    List<User> findAllUsers();
 
}