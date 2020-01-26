package com.test.app.repository;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.app.common.view.ViewModule;

@Repository("ViewModuleRepo")
public interface ViewModuleRepo extends PagingAndSortingRepository<ViewModule, Long>, QuerydslPredicateExecutor<ViewModule> {
	
	public List<ViewModule> findByUserName(String userName);

}
