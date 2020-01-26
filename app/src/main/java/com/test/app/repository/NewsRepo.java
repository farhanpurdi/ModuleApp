package com.test.app.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.app.common.entity.NewsEntity;

@Repository("NewsRepo")
public interface NewsRepo extends PagingAndSortingRepository<NewsEntity, Long>, QuerydslPredicateExecutor<NewsEntity> {

	public NewsEntity findByUserId(Long userId);
}
