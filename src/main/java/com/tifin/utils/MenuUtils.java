package com.tifin.utils;

import com.tifin.AllConstant.Constant;
import com.tifin.Utility.DataTypeUtility;
import com.tifin.dto.request.MenuRequestDTO;
import com.tifin.dto.response.MenuResponseDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.entity.Menu;
import com.tifin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuUtils {
    @Autowired
    private MenuService menuService;

    public NormalResponse addMenu(MenuRequestDTO menuRequestDTO) {
        NormalResponse response = new NormalResponse();
        response.setMessage(Constant.TECHNICAL_ERROR.getValue());
        response.setStatus(Constant.FAILED_STATUS.getValue());
        response.setCode(Constant.FAILED_CODE.getValue());
        try{
            if(DataTypeUtility.isNull(menuRequestDTO.getDay())){
                response.setMessage("Please select Day");
                return response;
            }
            if(DataTypeUtility.isNull(menuRequestDTO.getVegType())){
                response.setMessage("Please select veg Type");
                return  response;
            }
            Menu menu = new Menu();
            menu.setRoti(menuRequestDTO.getRoti());
            menu.setRice(menuRequestDTO.getRice());
            menu.setCurriedVeg(menuRequestDTO.getCurriedVeg());
            menu.setDryVeg(menuRequestDTO.getDryVeg());
            menu.setParatha(menuRequestDTO.getParatha());
            menu.setVegType(menuRequestDTO.getVegType());
            menu = menuService.saveMenu(menu);
            if(!DataTypeUtility.isNull(menu)){
                response.setMessage("Menu add successfully");
                response.setStatus(Constant.SUCCESS_STATUS.getValue());
                response.setCode(Constant.SUCCESS_CODE.getValue());
                return response;
            }
        }catch (Exception e){
            response.setMessage(Constant.TECHNICAL_ERROR.getValue());
            response.setStatus(Constant.EXCEPTION_OCCURRED_STATUS.getValue());
            response.setCode(Constant.EXCEPTION_OCCURRED_CODE.getValue());
            return response;
        }
        return response;
    }

    public MenuResponseDTO getMenu() {
        MenuResponseDTO response = new MenuResponseDTO();
        response.setMessage(Constant.TECHNICAL_ERROR.getValue());
        response.setStatus(Constant.FAILED_STATUS.getValue());
        response.setCode(Constant.FAILED_CODE.getValue());
        List<Menu> menuList = menuService.getMenuList();
        if(menuList.size() > 0){
            response.setMessage("Menu List");
            response.setStatus(Constant.SUCCESS_STATUS.getValue());
            response.setCode(Constant.SUCCESS_CODE.getValue());
        }
        return response;
    }
}
