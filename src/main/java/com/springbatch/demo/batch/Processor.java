package com.springbatch.demo.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.springbatch.demo.model.User;

@Component
public class Processor implements ItemProcessor<User, User>{

	private static final Map<String, String> DEPTS = new HashMap<>();
	
	public Processor() {
		DEPTS.put("001", "DEV");
		DEPTS.put("002", "QA");
		DEPTS.put("003", "PROD");
	}
	@Override
	public User process(User item) throws Exception {
		String dept = item.getDept();
		item.setDept(DEPTS.get(dept));
		return item;
	}

}
