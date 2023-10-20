package com.tifin.service;

import com.tifin.entity.User;


public interface UserService {
    User saveUser(User user);

    User getUserByEmailId(String emailId);
}
