package com.brasajava.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CrudResourceController <T> {
	
	ResponseEntity<T> save(T t);
	ResponseEntity<T> update(T t);
	ResponseEntity<Boolean> delete(long id);
	ResponseEntity<List<T>> getAll();
	ResponseEntity<T> getById(long id);

}
