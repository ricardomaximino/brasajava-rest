package com.brasajava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.model.CapoeiraMusic;
import com.brasajava.service.CapoeiraMusicService;
@CrossOrigin("*")
@RequestMapping("/public/capoeira/music")
@RestController
public class CapoeiraMusicController implements CrudResourceController<CapoeiraMusic>{
	
	@Autowired
	private CapoeiraMusicService service;
	
	@Override
	@PostMapping
	public ResponseEntity<CapoeiraMusic> save(@RequestBody CapoeiraMusic music) {
		return new ResponseEntity<CapoeiraMusic>(service.save(music),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<CapoeiraMusic> update(@RequestBody CapoeiraMusic music){
		return new ResponseEntity<CapoeiraMusic>(service.save(music),HttpStatus.OK);
	}
	
	@Override
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		System.out.println("DELETE");
		if(service.delete(id)) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@Override
	@GetMapping
	public ResponseEntity<List<CapoeiraMusic>> getAll(){
		return new ResponseEntity<List<CapoeiraMusic>>(service.getAll(),HttpStatus.OK);
	}
	
	@Override
	@GetMapping(value="/{id}")
	public ResponseEntity<CapoeiraMusic> getById(@PathVariable("id") long id){
		return new ResponseEntity<CapoeiraMusic>(service.getById(id),HttpStatus.OK);
	}

}
