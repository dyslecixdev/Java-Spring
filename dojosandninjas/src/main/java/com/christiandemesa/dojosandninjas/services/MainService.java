package com.christiandemesa.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christiandemesa.dojosandninjas.models.Dojo;
import com.christiandemesa.dojosandninjas.models.Ninja;
import com.christiandemesa.dojosandninjas.repositories.DojoRepository;
import com.christiandemesa.dojosandninjas.repositories.NinjaRepository;

@Service
public class MainService {

	/*
	Will create error if you structure the below as so:
	@Autowired
	DojoRepository dojoRepo;
	NinjaRepository ninjaRepo;
	*/
	@Autowired
	DojoRepository dojoRepo;
	
	@Autowired
	NinjaRepository ninjaRepo;
	
	// Dojo methods
	// This method creates a dojo.
	public void createDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	
	// This method returns all the dojos.
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	// This method returns one dojo.
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		}
		else {
			return null;
		}
	}
	
	// Ninja methods
	// This method creates a ninja.
	public void createNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
}