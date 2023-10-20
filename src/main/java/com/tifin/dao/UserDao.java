package com.tifin.dao;

import com.tifin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER WHERE EMAIL_ID = ?1",nativeQuery = true)
    User getUserByEmailId(String emailId);

    @Query(value = "SELECT * FROM USER WHERE ID = ?1",nativeQuery = true)
    User getUserById(Integer userId);
}
