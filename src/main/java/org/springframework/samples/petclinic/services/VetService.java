package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.stereotype.Service;

@Service
public class VetService {
	
	@Autowired
	private VetRepository vetRepository;

	
	public VetRepository getVetRepository() {
		return vetRepository;
	}

	public void setVetRepository(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	public List<Vet> findByLastName(String lastName){
		return vetRepository.findByLastName(lastName);
	}
	
	public List<Vet> findByFirstNameAndLastName(String firstName, String lastName){
		return vetRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public List<Vet> findByFirstNameOrLastName(String firstName, String lastName){
		return vetRepository.findByFirstNameOrLastName(firstName, lastName);
	}
	
	
	public List<Vet> findBySpecialtyName(String name){
		return vetRepository.findBySpecialtyName(name);
	}
}
