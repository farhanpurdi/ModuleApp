package com.test.app.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;

public interface ServiceApp {
	
	public Map<String, Object> insert(HashMap<String, Object> p_JsonParams)
			throws JsonParseException, IOException, ParseException;
	
	public List<Map<String, Object>> getData(String userId);

}
