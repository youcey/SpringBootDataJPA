package com.spb.springdatajpa.jpa;

import com.spb.springdatajpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//JpaRepository需要泛型接口参数，第一个参数是实体，第二则是主键的类型
@Transactional
public interface UserJPA extends JpaRepository<UserEntity,Long> {
    /**
     * @Query 是用来配置自定义SQL的注解
     * 参数nativeQuery = true 表明了使用原生的sql，如果不配置，默认是false，则使用HQL查询方式。
     * @param age
     * @return
     */
    @Query(value = "select * from t_user where t_age > ?1",nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    /**
     * @Query 注解好像只是用来查询的
     * 但是如果配合@Modifying注解一起使用，则可以完成数据的删除、添加、更新操作
     *
     * 抛出的异常TranscationRequiredException，意思是当前的操作抛出了需要事务异常，
     * SpringDataJPA自定义SQL时需要在对应的接口或者调用接口的地方添加事务注解@Transactional，来开启事务自动化管理
     * @param name
     * @param pwd
     */
    @Modifying
    @Query(value = "delete from t_user where t_name = ?1 and t_pwd = ?2",nativeQuery = true)
    public void deleteQuery(String name,String pwd);
}
