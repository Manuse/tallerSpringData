package org.springframework.samples.petclinic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
	
	@Autowired
	private VisitRepository visitRepository;

	public VisitRepository getVisitRepository() {
		return visitRepository;
	}

	public void setVisitRepository(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}
	
	public void save(Visit visit){
		visitRepository.save(visit);
	}
}
