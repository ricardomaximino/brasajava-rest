package com.brasajava.service;

import java.util.List;

public interface Service <T>{
	
	T save(T t);
	boolean delete(long id);
	T getById(long id);
	List<T> getAll();

}
