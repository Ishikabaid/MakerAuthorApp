package com.makercheckerapp.model.dao.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ishika_user_final1234")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userId;
    private String username;
    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId_fk")
    private List<String> profile = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(String username, String email, String password, List<String> profile) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public UserEntity(Integer userId, String username, String email, String password, List<String> profile) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getProfile() {
        return profile;
    }

    public void setProfile(List<String> profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity user = (UserEntity) o;
        return Objects.equals(userId, user.userId) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(profile, user.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, profile);
    }
}
