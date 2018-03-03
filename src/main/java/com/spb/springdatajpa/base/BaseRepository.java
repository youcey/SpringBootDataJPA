package com.spb.springdatajpa.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @NoRepositoryBean 这个注解如果配置在继承了JpaRepository接口以及其他SpringDataJpa内部的接口的子接口时，子接口不被作为一个Repository创建代理实现类。
 * @param <T>
 * @param <PK>
 */
@NoRepositoryBean
public interface BaseRepository<T,PK extends Serializable> extends JpaRepository<T,PK> {

}
