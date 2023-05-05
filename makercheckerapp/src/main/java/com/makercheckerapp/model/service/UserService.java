package com.makercheckerapp.model.service;

import com.makercheckerapp.model.dao.entities.UserEntity;

public interface UserService {
    void addUser(UserEntity user);
    UserEntity getUser(String email);
    UserEntity getUserByUsername(String username);
}
