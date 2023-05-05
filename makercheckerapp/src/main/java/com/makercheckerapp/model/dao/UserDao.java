package com.makercheckerapp.model.dao;

import com.makercheckerapp.model.dao.entities.UserEntity;

public interface UserDao {
    void addUser(UserEntity user);
    UserEntity getUser(String email);
    UserEntity getUserByUsername(String username);
}
