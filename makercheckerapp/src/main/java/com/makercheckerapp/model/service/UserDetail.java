package com.makercheckerapp.model.service;

import com.makercheckerapp.model.dao.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userdetail")
public class UserDetail implements UserDetailsService {
    private UserService userService;

    @Autowired
    public UserDetail(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = null;
        try {
            user = userService.getUser(email);
        }catch (DataAccessException ex){
            ex.printStackTrace();
            throw new UsernameNotFoundException("invalid login");
        }
        return new SecuredUser(user);
    }
}
