package com.tifin.dao;

import com.tifin.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderDao extends JpaRepository<UserOrder, Integer> {
}
