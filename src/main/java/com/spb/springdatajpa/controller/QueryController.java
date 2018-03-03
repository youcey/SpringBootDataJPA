package com.spb.springdatajpa.controller;

import com.querydsl.jpa.impl.JPAQuery;
import com.spb.springdatajpa.Inquirer;
import com.spb.springdatajpa.entity.GoodEntity;
import com.spb.springdatajpa.entity.QGoodEntity;
import com.spb.springdatajpa.jpa.GoodJpa;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class QueryController {

    @Autowired
    private GoodJpa goodJpa;
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/query")
    public List<GoodEntity> query(){
        //querydsl查询实体
        QGoodEntity _good = QGoodEntity.goodEntity;
        //构建JPA查询对象
        JPAQuery<GoodEntity> jpaQuery = new JPAQuery<>(entityManager);
        //返回查询接口
        return jpaQuery
                //查询字段
                .select(_good)
                //查询表
                .from(_good)
                //查询条件
                .where(_good.type.id.eq(Long.valueOf("1")))
                //返回结果
                .fetch();
    }

    @RequestMapping(value = "/join")
    public List<GoodEntity> join(){
        //querydsl查询实体
        QGoodEntity _good = QGoodEntity.goodEntity;
        //将下面内容封装成一个自定义的查询实体类
       /* //查询条件
        BooleanExpression expression = _good.type.id.eq(Long.valueOf("1"));
        //执行查询条件
        Iterator<GoodEntity> iterator = goodJpa.findAll(expression).iterator();

        List<GoodEntity> goods = new ArrayList<>();
        //转换成list
        while (iterator.hasNext()){
            goods.add(iterator.next());
        }
        return goods;*/
       //自定义查询对象
        Inquirer inquirer = new Inquirer();
        inquirer.putExpression(_good.type.id.eq(Long.valueOf("1")));
        return inquirer.iteratorToList(goodJpa.findAll(inquirer.buildQuery()));

    }
}
