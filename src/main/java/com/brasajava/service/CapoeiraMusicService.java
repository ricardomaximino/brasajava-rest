package com.brasajava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.brasajava.model.CapoeiraMusic;
import com.brasajava.repository.CapoeiraMusicRepository;

@Transactional
@org.springframework.stereotype.Service
public class CapoeiraMusicService implements Service<CapoeiraMusic> {
	@Autowired
	private CapoeiraMusicRepository capoeiraMusicRepository;

	@Override
	public CapoeiraMusic save(CapoeiraMusic capoeiraMusic) {
		return capoeiraMusicRepository.save(capoeiraMusic);
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;
		if(capoeiraMusicRepository.findOne(id) != null) {
			capoeiraMusicRepository.delete(id);
			result = true;
		}
		return result;
	}

	@Override
	public CapoeiraMusic getById(long id) {
		return capoeiraMusicRepository.findOne(id);
	}

	@Override
	public List<CapoeiraMusic> getAll() {
		List<CapoeiraMusic> list = new ArrayList<>();
		capoeiraMusicRepository.findAll().forEach(music -> list.add(music));
		return list;
	}

}
