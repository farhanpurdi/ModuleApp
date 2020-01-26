package com.test.app.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.app.common.entity.CategoryEntity;

@Repository("CategoryRepo")
public interface CategoryRepo extends PagingAndSortingRepository<CategoryEntity, Long>, QuerydslPredicateExecutor<CategoryEntity> {

	public CategoryEntity findByUserId(Long userId);
}
