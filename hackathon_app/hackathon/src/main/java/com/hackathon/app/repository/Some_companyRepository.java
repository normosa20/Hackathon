package com.hackathon.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.app.models.Some_company;

@Repository
public interface Some_companyRepository extends CrudRepository<Some_company, Long>  {
		List<Some_company> findAll();
	    Optional<Some_company>findById(Long id);
	    

}
