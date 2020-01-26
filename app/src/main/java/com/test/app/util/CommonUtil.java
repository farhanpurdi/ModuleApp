package com.test.app.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.app.AppConstants;

public class CommonUtil {

	public static Map<String, Object> generateErrorResponse(Integer status, String errorMessage){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put(AppConstants.RESP_STATUS, status);
		response.put(AppConstants.RESP_ERROR_MESSAGE, errorMessage);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Map<String, Object> convertFromPojoToMap(T tClass, Class<T> typeKey) {

		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String, Object> tClassAsMap = objectMapper.convertValue(tClass, Map.class);

		Map<String, Object> txInstrAsMapResult = new HashMap<String, Object>();
		for (Map.Entry<String, Object> tMap : tClassAsMap.entrySet()) {
			String keyMap = tMap.getKey();
			if (tClassAsMap.get(keyMap) != null) {
				txInstrAsMapResult.put(keyMap, tClassAsMap.get(keyMap));
			}
		}
		return txInstrAsMapResult;
	}
}
