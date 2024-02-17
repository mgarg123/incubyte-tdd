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
		String input4 = "1\n";
		int sum4 = incubyteTddApplication.add(input4);
		Assertions.assertEquals(1, sum4);

		String input5 = "\n1\n";
		int sum5 = incubyteTddApplication.add(input5);
		Assertions.assertEquals(1, sum5);

		String input6 = "\n\n1\n";
		int sum6 = incubyteTddApplication.add(input6);
		Assertions.assertEquals(1, sum6);

		//Handling negative number scenarios

		String input7 = "1,-2,3";
		Assertions.assertThrows(RuntimeException.class, () -> {
			incubyteTddApplication.add(input7);
		});

		String input8 = "-2,";
		Assertions.assertThrows(RuntimeException.class, () -> {
			incubyteTddApplication.add(input8);
		});

		String input12 = "1,2,-3,-4,-5";
		String exceptionMessage = Assertions.assertThrows(RuntimeException.class, () -> {
			incubyteTddApplication.add(input12);
		}).getMessage();

		Assertions.assertEquals("Negative numbers not allowed: -3,-4,-5", exceptionMessage);

		// Handling scenarios with change in delimiter, eg: //;\n1;2 -> here delimter is ;

		String input9 = "//;\n1;2";
		int sum9 = incubyteTddApplication.add(input9);
		Assertions.assertEquals(3, sum9);

		String input10 = "//:\n1:";
		String message = Assertions.assertThrows(RuntimeException.class, () -> {
			int sum10 = incubyteTddApplication.add(input10);
		}).getMessage();

		Assertions.assertEquals("String doesn't contain at least 2 numbers to add", message);

		//handling other cases

		String input11 = "0";
		int sum11 = incubyteTddApplication.add(input11);
		Assertions.assertEquals(0, sum11);

		//Code with different multiple delimiter
		String input13 = "1,2,3,3,4:";
		String exception13Message = Assertions.assertThrows(RuntimeException.class, () -> {
			incubyteTddApplication.add(input13);
		}).getMessage();

		Assertions.assertEquals("Invalid delimiters in the number",exception13Message);

	}

}
