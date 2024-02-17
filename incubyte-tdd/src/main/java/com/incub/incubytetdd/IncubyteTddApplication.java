package com.incub.incubytetdd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class IncubyteTddApplication implements CommandLineRunner {

	int add(String number){
		if(!StringUtils.hasLength(number) || number.equals("0"))
			return 0;
		int result = 0;
		if(number.contains(",")){
			String[] nums = number.split("[,\\n]");
		  	if(nums.length<2)
			  	throw new RuntimeException("String doesn't contain at least 2 numbers to add");
		    else {
				for(String  num: nums){
					result += Integer.parseInt(num);
				}
			}
		}else{
			String[] nums = number.split("[,\\n]");
			if(nums.length==1) return Integer.parseInt(nums[0]);
		}
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(IncubyteTddApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int res = add("1,2");
		System.out.println("Result: "+res);
	}
}
