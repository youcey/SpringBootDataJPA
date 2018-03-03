package com.spb.springdatajpa.controller;

import com.spb.springdatajpa.entity.UserEntity;
import com.spb.springdatajpa.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list")
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    //测试添加
    @RequestMapping(value = "/add")
    public String save() throws Exception{
        UserEntity userEntity = new UserEntity();
        userEntity.setName("ceshi");
        userEntity.setAddress("lanzhou");
        userEntity.setAge(24);
        userEntity.setPwd("000000");
        userEntity.setSex("女");
        userJPA.save(userEntity);
        return "用户添加成功";
    }
    //测试删除
    @RequestMapping(value = "/delelte")
    public String delete(Long id){
        userJPA.delete(id);
        return "删除成功";
    }

    @RequestMapping(value = "/age")
    public List<UserEntity> age(){
        return userJPA.nativeQuery(20);
    }

    @RequestMapping(value = "/deleteWhere")
    public String deleteWhere(){
        userJPA.deleteQuery("ceshi","000000");
        return "自定义SQL删除数据成功";
    }

    //分页
    @RequestMapping(value = "/cutPage")
    public List<UserEntity> cutPage(int page){
        UserEntity userEntity = new UserEntity();
        userEntity.setSize(2);
        userEntity.setPage(page);
        userEntity.setSord("desc");

        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(userEntity.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        //设置排序对象
        Sort sort = new Sort(sort_direction,userEntity.getSidx());
        //创建分页对象
        PageRequest pageRequest = new PageRequest(userEntity.getPage() - 1,userEntity.getSize(),sort);
        //执行分页查询
        return userJPA.findAll(pageRequest).getContent();
    }
}
