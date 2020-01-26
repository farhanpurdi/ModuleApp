package com.test.app.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.test.app.AppConstants;
import com.test.app.common.view.ViewModule;
import com.test.app.repository.ViewModuleRepo;
import com.test.app.service.ModuleService;
import com.test.app.service.ServiceApp;
import com.test.app.service.UserService;

@Service
@Component
public class ServiceAppImpl implements ServiceApp {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private ViewModuleRepo viewModuleRepo;
	
	@Override
	public Map<String, Object> insert(HashMap<String, Object> p_JsonParams)
			throws JsonParseException, IOException, ParseException {
		Map<String, Object> responData = new HashMap<String, Object>();
		Map<String, Object> responModule = new HashMap<String, Object>();
		HashMap<String, Object> paramData = new HashMap<String, Object>(p_JsonParams);
		HashMap<String, Object> paramDataUser = new HashMap<String, Object>(p_JsonParams);
		
		try {
			responData = userService.saveUser(paramDataUser);
			
			paramData.put(AppConstants.JSON_KEY_USER_ID, Long.valueOf(responData.get(AppConstants.JSON_KEY_ID).toString()));
			
			responModule = moduleService.saveModule(paramData);
			
			responData.put(AppConstants.JSON_KEY_MODULE, responModule);
		} catch (Exception e) {
			
			e.getClass();
		}
		
		return responData;
	}

	@Override
	public List<Map<String, Object>> getData(String userId) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			List<ViewModule> resultData = viewModuleRepo.findByUserName(userId);
			
			if(!resultData.isEmpty()) {
				for(ViewModule dataEntity : resultData) {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					if(dataEntity.getModuleName() != null) {
						dataMap.put(AppConstants.JSON_KEY_MODULE_NAME, dataEntity.getModuleName());
					}
					if(dataEntity.getModuleOrder() != null) {
						dataMap.put(AppConstants.JSON_KEY_MODULE_ORDER, dataEntity.getModuleOrder());
					}
					result.add(dataMap);
				}
				
			}
		} catch (Exception e) {
			
			e.getClass();
		}
		
		return result;
	}

}
