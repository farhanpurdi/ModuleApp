package com.test.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.app.AppConstants;
import com.test.app.common.entity.UserEntity;
import com.test.app.repository.UserRepo;
import com.test.app.service.UserService;
import com.test.app.util.CommonUtil;

@Service
@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public Map<String, Object> saveUser(HashMap<String, Object> p_JsonParam) {
		
		Map<String, Object> dataUser = null;
		UserEntity userEntity = new UserEntity();
		UserEntity m_userEntity = null;
		
		try {
			
			if(p_JsonParam.containsKey(AppConstants.JSON_KEY_ID)) {
				m_userEntity = userRepo.findById(Long.valueOf(p_JsonParam.get(AppConstants.JSON_KEY_ID).toString())).orElse(null);
			}
			
			if(m_userEntity != null) {
				userEntity.setId(m_userEntity.getId());
			} else {
				userEntity.setId(null);
			}
			
			if(p_JsonParam.get(AppConstants.JSON_KEY_USER_NAME) != null) {
				userEntity.setUserName(p_JsonParam.get(AppConstants.JSON_KEY_USER_NAME).toString());
			}
			
			userRepo.save(userEntity);
			dataUser = CommonUtil.convertFromPojoToMap(userEntity, UserEntity.class);
		} catch (Exception e) {
			// TODO: handle exception
			dataUser = CommonUtil.generateErrorResponse(500, "ERROR CAUSE" + e.getClass());
		}
		
		return dataUser;
	}

}
