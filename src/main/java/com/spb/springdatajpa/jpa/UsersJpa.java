package com.spb.springdatajpa.jpa;

import com.spb.springdatajpa.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpa extends JpaRepository<UsersEntity,Long> {
    //使用jpa自定义查询方法
    public UsersEntity findByUsername(String username);
}
