package com.brasajava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.brasajava.model.User;
import com.brasajava.repository.UserRepository;

@Transactional
@org.springframework.stereotype.Service
public class UserService implements Service<User> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;
		if(userRepository.findOne(id) != null) {
			userRepository.delete(id);
			result= true;
		}
		return result;
	}

	@Override
	public User getById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(user -> list.add(user));
		return list;
	}

}
