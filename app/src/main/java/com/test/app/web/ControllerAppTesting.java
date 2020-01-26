//package com.test.app.web;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//import java.util.Map;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.test.app.service.ServiceApp;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class ControllerAppTesting {
//	
//    @Autowired
//	private ServiceApp serviceApp;
//	
//	@Test
//	public void getData() throws Exception {
//		String userId = "UserA";
//		List<Map<String, Object>> result = serviceApp.getData(userId);
//		assertThat(!result.isEmpty());
//	}
//	
//	
//}
