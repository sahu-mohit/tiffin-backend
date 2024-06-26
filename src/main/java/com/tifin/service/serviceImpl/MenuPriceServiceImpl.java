package com.tifin.service.serviceImpl;

import com.tifin.dao.MenuPriceDao;
import com.tifin.entity.MenuPrice;
import com.tifin.service.MenuPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuPriceServiceImpl implements MenuPriceService {
    @Autowired
    MenuPriceDao menuPriceDao;
    @Override
    public MenuPrice savePrice(MenuPrice menuPrice) {
        try {
            if(menuPrice != null){
                return menuPriceDao.saveAndFlush(menuPrice);
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<MenuPrice> getMenuPriceList() {
        return menuPriceDao.findAll();
    }
}
