package com.hackathon.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.app.models.Some_company;
import com.hackathon.app.repository.Some_companyRepository;

@Service
public class Some_companyService {
	@Autowired
	private Some_companyRepository some_companyRepo;
	public Some_company createDes(Some_company some_company) {
		return some_companyRepo.save(some_company);
	}
	
//	---------------Find Project By Id -------------
	public Some_company findSomeById(Long id) {
		Optional<Some_company> potentialSome_company = some_companyRepo.findById(id);
		if(potentialSome_company.isPresent()) {
			return potentialSome_company.get();
		}
		else return null;
	}
}
