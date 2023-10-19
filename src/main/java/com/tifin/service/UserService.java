package com.tifin.service;

import com.tifin.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User saveUser(User user);
}
