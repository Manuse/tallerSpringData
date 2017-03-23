package org.springframework.samples.petclinic.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public PetRepository getPetRepository() {
		return petRepository;
	}

	public void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public List<PetType> findPetTypes(){
		return petRepository.findPetTypes();
	}

    public List<Pet> findByBirthDateBetweenOrderByBirthDateAsc(Date d1, Date d2){   	
    	return petRepository.findByBirthDateBetweenOrderByBirthDateAsc(d1, d2);
    }
}
