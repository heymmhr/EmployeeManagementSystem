package com.ems.ems;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

	@Test
	void contextLoads() {

		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("os.name"));
	}

}
