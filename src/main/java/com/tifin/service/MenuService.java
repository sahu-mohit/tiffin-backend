package com.tifin.service;

import com.tifin.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MenuService {
    Menu saveMenu(Menu menu);

    List<Menu> getMenuList();
}
