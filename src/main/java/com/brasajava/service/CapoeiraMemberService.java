package com.brasajava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.brasajava.model.CapoeiraMember;
import com.brasajava.repository.CapoeiraMemberRepository;

@Transactional
@org.springframework.stereotype.Service
public class CapoeiraMemberService implements Service<CapoeiraMember>{
	
	@Autowired
	private CapoeiraMemberRepository repository;

	@Override
	public CapoeiraMember save(CapoeiraMember capoeiraMember) {
		return repository.save(capoeiraMember);
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;
		if(repository.findOne(id) != null){
			repository.delete(id);
			result = true;
		}
		return result;
	}

	@Override
	public CapoeiraMember getById(long id) {
		return repository.findOne(id);
	}

	@Override
	public List<CapoeiraMember> getAll() {
		List<CapoeiraMember> list = new ArrayList<>();
		repository.findAll().forEach(member -> list.add(member));
		return list;
	}

}
