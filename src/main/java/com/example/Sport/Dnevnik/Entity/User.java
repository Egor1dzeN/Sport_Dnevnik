package com.example.Sport.Dnevnik.Entity;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "test")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public User(String username, String email, String password, boolean isSuccessMail, Date birthday, Long imageAvatarId, String name, String surname) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isSuccessMail = isSuccessMail;
        this.birthday = birthday;
        this.imageAvatarId = imageAvatarId;
        this.name = name;
        this.surname = surname;
    }

    public User(Long id, String username, String email, String password, boolean isSuccessMail, Date birthday, Long imageAvatarId, String name, String surname) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isSuccessMail = isSuccessMail;
        this.birthday = birthday;
        this.imageAvatarId = imageAvatarId;
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSuccessMail() {
        return isSuccessMail;
    }

    public void setSuccessMail(boolean successMail) {
        isSuccessMail = successMail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getImageAvatarId() {
        return imageAvatarId;
    }

    public void setImageAvatarId(Long imageAvatarId) {
        this.imageAvatarId = imageAvatarId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String password;

    private boolean isSuccessMail = true;

    private Date birthday;

    private Long imageAvatarId;
    private String name;
    private String surname;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
