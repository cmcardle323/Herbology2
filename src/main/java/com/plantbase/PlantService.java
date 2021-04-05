package com.plantbase;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlantService {

	@Autowired //inject plant repo to auto call CRUD layer at runtime
	private PlantRepository plantRepo;
	
	public List<Plant> listAll() {
		return plantRepo.findAll();
	}
	
	public void save(Plant plant) {
		plantRepo.save(plant);
	}
	
	public Plant get(long id) {
		return plantRepo.findById(id).get();
	}
	
	public void delete(long id) {
		plantRepo.deleteById(id);
	}
}
