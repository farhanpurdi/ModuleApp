package com.test.app.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.app.common.entity.HistoryEntity;

@Repository("HistoryRepo")
public interface HistoryRepo extends PagingAndSortingRepository<HistoryEntity, Long>, QuerydslPredicateExecutor<HistoryEntity> {

	public HistoryEntity findByUserId(Long userId);
}
