package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
	
	@Autowired
	private OwnerRepository ownerRepository;

	public OwnerRepository getOwnerRepository() {
		return ownerRepository;
	}

	public void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}
	
	public List<Owner> findByFirstNameOrLastName(String firstname, String lastname){
		return ownerRepository.findByFirstNameContainingOrLastNameContaining(firstname, lastname);
	}
	
	public List<Owner> findByOrderByLastName(){
		return ownerRepository.findByOrderByLastName();
	}
	
	public Owner findById(int id){
		return ownerRepository.findById(id);
	}
	
}
