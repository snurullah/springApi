package com.adresetiket.AdresEtiket.Service;

import com.adresetiket.AdresEtiket.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void createUser(User user);

    void updateUser(User user);

    void deleteById(Integer userId);

    List<User> getList();

    Optional<User> getUser(Integer userId);

    User getLoginUserName(String name);
}