package com.spb.springdatajpa.service;

import com.spb.springdatajpa.entity.UsersEntity;
import com.spb.springdatajpa.jpa.UsersJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UsersService implements UserDetailsService {
    @Autowired
    private UsersJpa usersJpa;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity = usersJpa.findByUsername(username);
        if(usersEntity == null){
            throw new UsernameNotFoundException("未查到用户："+username+ "信息！");
        }
        return usersEntity;
    }

}
