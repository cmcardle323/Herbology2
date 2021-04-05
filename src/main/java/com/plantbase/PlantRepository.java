package com.plantbase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
	// extends default CRUD interface to save on boilerplate code
}
