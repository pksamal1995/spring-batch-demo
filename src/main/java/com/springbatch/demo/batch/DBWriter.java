package com.springbatch.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbatch.demo.model.User;
import com.springbatch.demo.repository.UserRepository;

@Component
public class DBWriter  implements ItemWriter<User>{

	@Autowired
	private UserRepository repository;
	
	@Override
	public void write(List<? extends User> items) throws Exception {
		System.out.println("Data Saved as User" + items);
		repository.saveAll(items);
	}

}
