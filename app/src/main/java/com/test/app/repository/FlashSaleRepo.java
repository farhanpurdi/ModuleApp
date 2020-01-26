package com.test.app.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.app.common.entity.FlashSaleEntity;

@Repository("FlashSaleRepo")
public interface FlashSaleRepo extends PagingAndSortingRepository<FlashSaleEntity, Long>, QuerydslPredicateExecutor<FlashSaleEntity> {

	public FlashSaleEntity findByUserId(Long userId);
}
