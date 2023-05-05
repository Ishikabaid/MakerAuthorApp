package com.makercheckerapp.model.dao.impl;

import com.makercheckerapp.model.dao.UserDao;
import com.makercheckerapp.model.dao.entities.UserEntity;
import com.makercheckerapp.model.exception.ResourceNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository @Primary
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void addUser(UserEntity user) {
        getSession().persist(user);
    }

    @Override
    public UserEntity getUser(String email) {
        List<UserEntity> users = getSession().createQuery(
                "select u from UserEntity u where u.email=:email", UserEntity.class)
                .setParameter("email",email).getResultList();
        if (!users.isEmpty())
            return users.get(0);
        else
            throw new ResourceNotFoundException("user not found!");
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        List<UserEntity> users = getSession().createQuery(
                        "select u from UserEntity u where u.username=:username", UserEntity.class)
                .setParameter("username",username).getResultList();
        if (!users.isEmpty())
            return users.get(0);
        else
            throw new ResourceNotFoundException("user not found!");
    }
}
