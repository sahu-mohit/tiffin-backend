package com.tifin.service.serviceImpl;

import com.tifin.dao.MenuDao;
import com.tifin.entity.Menu;
import com.tifin.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MenuServieImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Override
    public Menu saveMenu(Menu menu) {
        try{
            return menuDao.saveAndFlush(menu);
        }catch (Exception e){
            log.error("Exception in saveMenu: "+ e);
            return null;
        }
    }

    @Override
    public List<Menu> getMenuList() {
        try{
            return menuDao.findAll();
        }catch (Exception e){
            log.error("Excption in getMenuList() : "+ e);
            return null;
        }
    }
}
