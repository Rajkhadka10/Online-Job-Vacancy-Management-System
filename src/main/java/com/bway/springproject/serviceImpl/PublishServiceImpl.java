
package com.bway.springproject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springproject.model.Publish;
import com.bway.springproject.repository.PublishRepository;
import com.bway.springproject.service.PublishService;

@Service
public class PublishServiceImpl implements PublishService{

	@Autowired
	private PublishRepository publRepo;
	@Override
	
	public void addPubl(Publish publ) {
		publRepo.save(publ);
		
	}

	@Override
	public void deletePubl(int id) {
		publRepo.deleteById(id);
		
	}

	@Override
	public void updatePubl(Publish publ) {
		publRepo.save(publ);
		
	}

	@Override
	public Publish getPublById(int id) {
		return publRepo.findById(id).get();
		
		
	}

	@Override
	public List<Publish> getAllPubls() {
		
		return publRepo.findAll();
	}

	@Override
	public void ApplyPubl(Publish publ) {
	 publRepo.save(publ);
	}

	
}

