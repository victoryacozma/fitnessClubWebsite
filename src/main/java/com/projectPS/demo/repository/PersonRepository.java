package com.projectPS.demo.repository;

import com.projectPS.demo.model.UserAuth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonRepository extends CrudRepository<UserAuth, Long> {
}
