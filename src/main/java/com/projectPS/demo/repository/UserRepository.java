package com.projectPS.demo.repository;

import com.projectPS.demo.model.UserAuth;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserAuth, Long> {
    UserAuth findByUsername(String username);
}
