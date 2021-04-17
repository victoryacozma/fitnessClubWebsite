package com.projectPS.demo.repository;

import com.projectPS.demo.model.FitnessGroup;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<FitnessGroup, Long> {
}
