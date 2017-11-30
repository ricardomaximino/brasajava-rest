package com.brasajava.repository;

import org.springframework.data.repository.CrudRepository;

import com.brasajava.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
