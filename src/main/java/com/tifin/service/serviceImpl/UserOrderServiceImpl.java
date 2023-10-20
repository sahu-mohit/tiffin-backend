package com.tifin.service.serviceImpl;

import com.tifin.dao.UserOrderDao;
import com.tifin.dto.request.UserOrderRequestDTO;
import com.tifin.entity.UserOrder;
import com.tifin.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderDao userOrderDao;
    @Override
    public UserOrder saveOrder(UserOrder userOrder) {
        try{
            return userOrderDao.saveAndFlush(userOrder);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
