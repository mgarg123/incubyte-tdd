package com.incub.incubytetdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IncubyteTddApplicationTests {

	@Autowired
	IncubyteTddApplication incubyteTddApplication;

	@Test
	void contextLoads() {
	}

	@Test
	void testAdd(){
		String input0= "";
		int sum0 = incubyteTddApplication.add(input0);
		Assertions.assertEquals(0, sum0);
		String input1 = "1,5";
		int sum1 = incubyteTddApplication.add(input1);
		Assertions.assertEquals(6, sum1);
		String input2 = "1\n2,3";
		int sum2 = incubyteTddApplication.add(input2);
		Assertions.assertEquals(6, sum2);
		String input3 = "1,\n";
		Assertions.assertThrows(RuntimeException.class, () -> {
			incubyteTddApplication.add(input3);
		});



	}

}
