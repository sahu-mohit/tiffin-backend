package com.tifin.service;

import com.tifin.dto.request.UserOrderRequestDTO;
import com.tifin.entity.UserOrder;


public interface UserOrderService {

    UserOrder saveOrder(UserOrder Userorder);
}
