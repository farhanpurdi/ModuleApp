package com.test.app.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.app.common.entity.UserEntity;

@Repository("UserRepo")
public interface UserRepo extends PagingAndSortingRepository<UserEntity, Long>, QuerydslPredicateExecutor<UserEntity> {

}
