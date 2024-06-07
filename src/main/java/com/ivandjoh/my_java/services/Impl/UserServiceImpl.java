package com.ivandjoh.my_java.services.Impl;

import com.ivandjoh.my_java.dtos.User;
import com.ivandjoh.my_java.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    private final String externalApiUrl;

    public UserServiceImpl(RestTemplate restTemplate, String externalApiUrl) {
        this.restTemplate = restTemplate;
        this.externalApiUrl = externalApiUrl;
    }

    @Override
    public List<User> getAllUsers() {
        User[] users = restTemplate.getForObject(externalApiUrl, User[].class);
        return Arrays.asList(users);
    }

    @Override
    public User getUserById(Long id) {
        String url = externalApiUrl + "/" + id;
        return restTemplate.getForObject(url, User.class);
    }
}
