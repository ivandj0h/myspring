package com.ivandjoh.my_java.services;

import com.ivandjoh.my_java.dtos.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);
}
