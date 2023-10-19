package com.tifin.service.serviceImpl;

import com.tifin.dao.UserDao;
import com.tifin.entity.User;
import com.tifin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public User saveUser(User user) {
        if(user != null){
            return userDao.saveAndFlush(user);
        }else{
            return null;
        }
    }
}
