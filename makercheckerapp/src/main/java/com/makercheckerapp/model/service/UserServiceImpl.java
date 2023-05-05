package com.makercheckerapp.model.service;

import com.makercheckerapp.model.dao.UserDao;
import com.makercheckerapp.model.dao.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userService")
@Primary
@Transactional
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(UserEntity user) {
        userDao.addUser(user);
    }

    @Override
    public UserEntity getUser(String email) {
        return userDao.getUser(email);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
