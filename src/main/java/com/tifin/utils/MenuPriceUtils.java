package com.tifin.utils;

import com.tifin.AllConstant.Constant;
import com.tifin.Utility.DataTypeUtility;
import com.tifin.dto.request.MenuPriceRequestDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.entity.MenuPrice;
import com.tifin.service.MenuPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuPriceUtils {
    @Autowired
    private MenuPriceService menuPriceService;
    public NormalResponse setItemPrice(MenuPriceRequestDTO menuPriceRequestDTO){
        NormalResponse normalResponse = new NormalResponse();
        try{
            String itemName = menuPriceRequestDTO.getItemName();
            Float price = menuPriceRequestDTO.getPrice();
            if(DataTypeUtility.isNull(itemName)){
                normalResponse.setMessage("Please fill the Item name");
            }
            if(DataTypeUtility.isNull(price)){
                normalResponse.setMessage("Please fill the item Price");
            }
            MenuPrice menuPrice = new MenuPrice();
            menuPrice.setItemName(itemName);
            menuPrice.setPrice(price);
            menuPrice = menuPriceService.savePrice(menuPrice);
            if(DataTypeUtility.isNull(menuPrice)){
                normalResponse.setMessage(Constant.ERROR.getValue());
                normalResponse.setStatus(Constant.FAILED_STATUS.getValue());
                normalResponse.setCode(Constant.FAILED_CODE.getValue());
            }else{
                normalResponse.setMessage("Price Saved Successfully");
                normalResponse.setCode(Constant.SUCCESS_CODE.getValue());
                normalResponse.setStatus(Constant.SUCCESS_STATUS.getValue());
            }
        }catch (Exception e){
            normalResponse.setMessage(Constant.TECHNICAL_ERROR.getValue());
            normalResponse.setCode(Constant.FAILED_CODE.getValue());
            normalResponse.setStatus(Constant.FAILED_STATUS.getValue());
        }
        return normalResponse;
    }

}
