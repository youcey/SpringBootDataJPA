package com.spb.springdatajpa.jpa;

import com.spb.springdatajpa.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface GoodJpa extends JpaRepository<GoodEntity,Long>,QueryDslPredicateExecutor<GoodEntity> {

}
