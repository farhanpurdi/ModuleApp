package com.test.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.app.AppConstants;
import com.test.app.common.entity.CategoryEntity;
import com.test.app.common.entity.FlashSaleEntity;
import com.test.app.common.entity.HistoryEntity;
import com.test.app.common.entity.NewsEntity;
import com.test.app.common.entity.PromoEntity;
import com.test.app.repository.CategoryRepo;
import com.test.app.repository.FlashSaleRepo;
import com.test.app.repository.HistoryRepo;
import com.test.app.repository.NewsRepo;
import com.test.app.repository.PromoRepo;
import com.test.app.service.ModuleService;
import com.test.app.util.CommonUtil;

@Service
@Component
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private FlashSaleRepo flashSaleRepo;
	
	@Autowired
	private HistoryRepo historyRepo;
	
	@Autowired
	private NewsRepo newsRepo;
	
	@Autowired
	private PromoRepo promoRepo;
	
	@Override
	public Map<String, Object> saveModule(HashMap<String, Object> p_JsonParam) {
		Map<String, Object> responModule = new HashMap<String, Object>();
		
		CategoryEntity categoryEntity 	= new CategoryEntity();
		FlashSaleEntity flashSaleEntity = new FlashSaleEntity();
		HistoryEntity historyEntity 	= new HistoryEntity();
		NewsEntity newsEntity 			= new NewsEntity();
		PromoEntity promoEntity 		= new PromoEntity();
		
		CategoryEntity m_CategoryEntity = null;
		FlashSaleEntity m_FlashSaleEntity = null;
		HistoryEntity m_HistoryEntity = null;
		NewsEntity m_NewsEntity = null;
		PromoEntity m_PromoEntity = null;

		try {
			if(p_JsonParam.containsKey(AppConstants.JSON_KEY_USER_ID)) {
				Long userId = Long.valueOf(p_JsonParam.get(AppConstants.JSON_KEY_USER_ID).toString());
				if(userId != null) {
					
					m_CategoryEntity = categoryRepo.findByUserId(userId);
					if(m_CategoryEntity != null) {
						categoryEntity.setId(m_CategoryEntity.getId());
						categoryEntity.setUserId(m_CategoryEntity.getUserId());
					} else {
						categoryEntity.setId(null);
						categoryEntity.setUserId(userId);
					}
					
					m_FlashSaleEntity = flashSaleRepo.findByUserId(userId);
					if(m_FlashSaleEntity != null) {
						flashSaleEntity.setId(m_FlashSaleEntity.getId());
						flashSaleEntity.setUserId(m_FlashSaleEntity.getUserId());
					} else {
						flashSaleEntity.setId(null);
						flashSaleEntity.setUserId(userId);
					}
					
					m_HistoryEntity = historyRepo.findByUserId(userId);
					if(m_HistoryEntity != null) {
						historyEntity.setId(m_HistoryEntity.getId());
						historyEntity.setUserId(m_HistoryEntity.getUserId());
					} else {
						historyEntity.setId(null);
						historyEntity.setUserId(userId);
					}
					
					m_NewsEntity = newsRepo.findByUserId(userId);
					if(m_NewsEntity != null) {
						newsEntity.setId(m_NewsEntity.getId());
						newsEntity.setUserId(m_NewsEntity.getUserId());
					} else {
						newsEntity.setId(null);
						newsEntity.setUserId(userId);
					}
					
					m_PromoEntity = promoRepo.findByUserId(userId);
					if(m_PromoEntity != null) {
						promoEntity.setId(m_PromoEntity.getId());
						promoEntity.setUserId(m_PromoEntity.getUserId());
					} else {
						promoEntity.setId(null);
						promoEntity.setUserId(userId);
					}
				}
			}
			
			if(p_JsonParam.containsKey(AppConstants.JSON_KEY_PRIVILEGE_CATEGORY)) {
				Long privilege = Long.valueOf(p_JsonParam.get(AppConstants.JSON_KEY_PRIVILEGE_CATEGORY).toString());
				if(privilege != null) {
					categoryEntity.setPrivileges(privilege);
				} else {
					categoryEntity.setPrivileges(m_CategoryEntity.getPrivileges());
				}
			}
			
			if(p_JsonParam.containsKey(AppConstants.JSON_KEY_PRIVILEGE_FLASH_SALE)) {
				Long privilege = Long.valueOf(p_JsonParam.get(AppConstants.JSON_KEY_PRIVILEGE_FLASH_SALE).toString());
				if(privilege != null) {
					flashSaleEntity.setPrivileges(privilege);
				} else {
					flashSaleEntity.setPrivileges(m_FlashSaleEntity.getPrivileges());
				}
			}
			
			if(p_JsonParam.containsKey(AppConstants.JSON_KEY_PRIVILEGE_HISTORY)) {
				Long privilege = Long.valueOf(p_JsonParam.get(AppConstants.JSON_KEY_PRIVILEGE_HISTORY).toString());
				if(privilege != null) {
					historyEntity.setPrivileges(privilege);
				} else {
					historyEntity.setPrivileges(m_HistoryEntity.getPrivileges());
				}
			}
			
			if(p_JsonParam.containsKey(AppConstants.JSON_KEY_PRIVILEGE_NEWS)) {
				Long privilege = Long.valueOf(p_JsonParam.get(AppConstants.JSON_KEY_PRIVILEGE_NEWS).toString());
				if(privilege != null) {
					newsEntity.setPrivileges(privilege);
				} else {
					newsEntity.setPrivileges(m_NewsEntity.getPrivileges());
				}
			}
			
			if(p_JsonParam.containsKey(AppConstants.JSON_KEY_PRIVILEGE_PROMO)) {
				Long privilege = Long.valueOf(p_JsonParam.get(AppConstants.JSON_KEY_PRIVILEGE_PROMO).toString());
				if(privilege != null) {
					promoEntity.setPrivileges(privilege);
				} else {
					promoEntity.setPrivileges(m_PromoEntity.getPrivileges());
				}
			}
			
			categoryRepo.save(categoryEntity);
			flashSaleRepo.save(flashSaleEntity);
			historyRepo.save(historyEntity);
			newsRepo.save(newsEntity);
			promoRepo.save(promoEntity);
			
			CategoryEntity categoryResponse = categoryRepo.findById(categoryEntity.getId()).orElse(null);
			FlashSaleEntity flashSaleResponse = flashSaleRepo.findById(flashSaleEntity.getId()).orElse(null);
			HistoryEntity historyResponse = historyRepo.findById(historyEntity.getId()).orElse(null);
			NewsEntity newsResponse	= newsRepo.findById(newsEntity.getId()).orElse(null);
			PromoEntity promoResponse = promoRepo.findById(promoEntity.getId()).orElse(null);
			
			responModule.put(AppConstants.JSON_KEY_CATEGORY, CommonUtil.convertFromPojoToMap(categoryResponse, CategoryEntity.class));
			responModule.put(AppConstants.JSON_KEY_FLASH_SALE, CommonUtil.convertFromPojoToMap(flashSaleResponse, FlashSaleEntity.class));
			responModule.put(AppConstants.JSON_KEY_HISTORY, CommonUtil.convertFromPojoToMap(historyResponse, HistoryEntity.class));
			responModule.put(AppConstants.JSON_KEY_NEWS, CommonUtil.convertFromPojoToMap(newsResponse, NewsEntity.class));
			responModule.put(AppConstants.JSON_KEY_PROMO, CommonUtil.convertFromPojoToMap(promoResponse, PromoEntity.class));
			
		} catch (Exception e) {
			// TODO: handle exception
			responModule = CommonUtil.generateErrorResponse(500, "ERROR CAUSE" + e.getClass());
		}
		
		return responModule;
	}

}
