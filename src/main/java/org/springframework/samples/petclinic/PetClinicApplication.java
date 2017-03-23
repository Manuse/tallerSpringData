/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.SpecialityRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.services.OwnerService;
import org.springframework.samples.petclinic.services.PetService;
import org.springframework.samples.petclinic.services.VisitService;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PetClinicApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);       
    }
    
    @Bean
	public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialityRepository specialityRepository, OwnerService ownerService, PetService petService, VisitService visitService) {
		return (args) -> {
			log.info("*****************************************************");
			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
			log.info("*****************************************************");
			
			//TODO Añade aquí tu código			
			/*List<Vet> lv = vetRepository.findByLastName("Leary");			
			for(int i=0; i<lv.size();i++){
				System.err.println(lv.get(i));
			}
			System.out.println();
			lv = vetRepository.findByFirstNameAndLastName("manu", "aguilar");			
			for(int i=0; i<lv.size();i++){
				System.err.println(lv.get(i));
			}
			System.out.println();
			lv = vetRepository.findByFirstNameOrLastName("manu", "Carter");			
			for(int i=0; i<lv.size();i++){
				System.err.println(lv.get(i));
			}
			
			List<Vet> lv = vetRepository.findBySpecialtyName("Radiology");			
			for(int i=0; i<lv.size();i++){
				System.err.println(lv.get(i));
			}
			
			List<Owner> lv = ownerRepository.findByFirstNameOrLastName("ma", "da");			
			for(int i=0; i<lv.size();i++){
				System.err.println(lv.get(i));
			}
			
			lv = ownerRepository.findByOrderByLastName();
			for(int i=0; i<lv.size();i++){
				System.err.println(lv.get(i));
			}*/
			
			List<Pet> lp = petService.findByBirthDateBetweenOrderByBirthDateAsc(new Date(2010, 11, 1), new Date(1900, 11, 1));			
			for(int i=0; i<lp.size();i++){
				System.err.println(lp.get(i));
			}			
			System.out.println();
			
			
			Date date = new Date();
			date.setYear(2010);
			
			for(int i=0; i<5;i++){
			Visit v=new Visit();
			date.setMonth(i);
			v.setDate(date);
			v.setPetId(1);
			v.setDescription("enfermo");
			visitService.save(v);
			}
		};
	}
    
}
