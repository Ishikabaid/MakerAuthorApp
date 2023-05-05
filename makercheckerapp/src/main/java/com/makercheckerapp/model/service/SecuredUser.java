package com.makercheckerapp.model.service;

import com.makercheckerapp.model.dao.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class SecuredUser implements UserDetails {
    private UserEntity userEntity;

    public SecuredUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//      String user = userEntity.getProfile();
//      return AuthorityUtils.createAuthorityList(user);
        List<String> userProfile = userEntity.getProfile();
//        List<String> userList = new ArrayList<>();
//        userList.add(user);
        String[] userArr = userProfile.toArray(new String[userProfile.size()]);
        return AuthorityUtils.createAuthorityList(userArr);
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
