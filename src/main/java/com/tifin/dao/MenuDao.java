package com.tifin.dao;

import com.tifin.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDao extends JpaRepository<Menu, Integer> {
}
