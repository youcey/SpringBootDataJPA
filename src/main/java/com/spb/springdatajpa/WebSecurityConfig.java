package com.spb.springdatajpa;

import com.spb.springdatajpa.service.UsersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService usersService(){
        return new UsersService();
    }

    //完成自定义认证实体注入
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated()//所有请求必须登陆后访问
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .permitAll()//登录界面，错误界面可以直接访问
            .and()
            .logout()
            .permitAll();//注销请求可直接访问
    }

}
