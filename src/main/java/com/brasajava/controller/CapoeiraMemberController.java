package com.brasajava.controller;

import java.security.Principal;
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

import com.brasajava.model.CapoeiraMember;
import com.brasajava.service.CapoeiraMemberService;

@RestController
@CrossOrigin("*")
@RequestMapping("/public/capoeira/member")
public class CapoeiraMemberController implements CrudResourceController<CapoeiraMember> {
	
	@Autowired
	private CapoeiraMemberService service;

	@Override
	@PostMapping
	public ResponseEntity<CapoeiraMember> save(@RequestBody CapoeiraMember capoeiraMember) {
		return new ResponseEntity<CapoeiraMember>(service.save(capoeiraMember),HttpStatus.OK);
	}

	@Override
	@PutMapping
	public ResponseEntity<CapoeiraMember> update(@RequestBody CapoeiraMember capoeiraMember) {
		return new ResponseEntity<CapoeiraMember>(service.save(capoeiraMember), HttpStatus.OK);
	}

	@Override
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		if(service.delete(id)) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<CapoeiraMember>> getAll() {
		return new ResponseEntity<List<CapoeiraMember>>(service.getAll(), HttpStatus.OK);
	}

	@Override
	@GetMapping(value="/{id}")
	public ResponseEntity<CapoeiraMember> getById(@PathVariable("id") long id) {
		return new ResponseEntity<CapoeiraMember>(service.getById(id), HttpStatus.OK);
	}

}
