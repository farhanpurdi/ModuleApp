package com.test.app.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.app.AppConstants;
import com.test.app.service.ServiceApp;

@RestController
@RequestMapping(AppConstants.PATH_GENERAL)
public class ControllerApp {
	
	@Autowired
	private ServiceApp serviceApp;
	
	@Autowired
	public ObjectMapper objectMapper;
	
	@RequestMapping(value = AppConstants.INSERT, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> insertData(@RequestBody HashMap<String, Object> p_JsonParam)
			throws JsonParseException, IOException, ParseException {
		Map<String, Object> saveData = serviceApp.insert(p_JsonParam);
		return new ResponseEntity<Map<String, Object>>(saveData, HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/{userId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getData(@PathVariable(name="userId") String userId)
			throws JsonParseException, IOException, ParseException {
		Map<String, Object> dataResponse = new HashMap<String, Object>();
		List<Map<String, Object>> result = serviceApp.getData(userId);
		dataResponse.put(AppConstants.JSON_KEY_MODULES, result);
		return dataResponse;
	}
	
}
