package com.manu.learning.user.repo;

import com.manu.learning.user.entity.EntityUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<EntityUserDetails, Integer> {
    ArrayList<EntityUserDetails> findByEmail(String email);
}
