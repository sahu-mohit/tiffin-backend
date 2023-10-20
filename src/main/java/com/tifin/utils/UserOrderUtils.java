package com.tifin.utils;

import com.tifin.AllConstant.Constant;
import com.tifin.Utility.DataTypeUtility;
import com.tifin.dto.request.UserOrderRequestDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.entity.UserOrder;
import com.tifin.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderUtils {

    @Autowired
    private UserOrderService userOrderService;

    public NormalResponse userOrder(UserOrderRequestDTO userOrderRequestDTO){
        NormalResponse normalResponse = new NormalResponse();
        normalResponse.setMessage("Order not placed please try again");
        normalResponse.setStatus(Constant.FAILED_STATUS.getValue());
        normalResponse.setCode(Constant.FAILED_CODE.getValue());
        UserOrder userOrder = new UserOrder();
        if(DataTypeUtility.isNull(userOrderRequestDTO.getStartDateTime())){
            normalResponse.setMessage("Please select date");
        }
        if(DataTypeUtility.isNull(userOrderRequestDTO.getEndDateTime())){
            normalResponse.setMessage("Please select date");
        }
        if(DataTypeUtility.isNull(userOrderRequestDTO.getIsVeg())){
            normalResponse.setMessage("Please select Food Type");
        }
        if(DataTypeUtility.isNull(userOrderRequestDTO.getQuantity())){
            normalResponse.setMessage("Please fill the Quantity");
        }
        if(userOrderRequestDTO.getUserId() != null) {
            userOrder.setUserId(userOrderRequestDTO.getUserId());
            userOrder.setAchar(userOrderRequestDTO.getAchar());
            userOrder.setCurriedVeg(userOrderRequestDTO.getCurriedVeg());
            userOrder.setDryVeg(userOrderRequestDTO.getDryVeg());
            userOrder.setRoti(userOrderRequestDTO.getRoti());
            userOrder.setRice(userOrderRequestDTO.getRice());
            userOrder.setSweet(userOrderRequestDTO.getSweet());
            userOrder.setRayeta(userOrderRequestDTO.getRayeta());
            userOrder.setDay(userOrderRequestDTO.getDay());
            userOrder.setStartDateTime(DataTypeUtility.getChangeDateFormat(Constant.INDIAN_DATE_FORMAT.getValue(), userOrderRequestDTO.getStartDateTime()));
            userOrder.setEndDateTime(DataTypeUtility.getChangeDateFormat(Constant.INDIAN_DATE_FORMAT.getValue(), userOrderRequestDTO.getEndDateTime()));
            userOrder.setAmount(userOrderRequestDTO.getAmount());
            userOrder.setIsVeg(userOrderRequestDTO.getIsVeg());
            userOrder.setParatha(userOrderRequestDTO.getParatha());
            userOrder.setQuantity(userOrderRequestDTO.getQuantity());
            userOrder.setSaledChatni(userOrderRequestDTO.getSaledChatni());
            userOrder.setTiffinType(userOrderRequestDTO.getTiffinType());
            userOrder = userOrderService.saveOrder(userOrder);
            if (userOrder != null) {
                normalResponse.setMessage("Order place successfully");
                normalResponse.setCode(Constant.SUCCESS_CODE.getValue());
                normalResponse.setStatus(Constant.SUCCESS_STATUS.getValue());
            }
        }
        return normalResponse;
    }
}
