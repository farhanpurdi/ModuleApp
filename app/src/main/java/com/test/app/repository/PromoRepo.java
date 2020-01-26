package com.test.app.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.app.common.entity.PromoEntity;

@Repository("PromoRepo")
public interface PromoRepo extends PagingAndSortingRepository<PromoEntity, Long>, QuerydslPredicateExecutor<PromoEntity> {

	public PromoEntity findByUserId(Long userId);
}
