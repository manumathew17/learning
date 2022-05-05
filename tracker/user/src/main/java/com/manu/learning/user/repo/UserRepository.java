package com.manu.learning.user.repo;

import com.manu.learning.user.entity.EntityUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<EntityUserDetails, Integer> {
    ArrayList<EntityUserDetails> findByEmail(String email);
    ArrayList<EntityUserDetails> findByEmailAndPrimarycontactnum(String email, String contact);
    ArrayList<EntityUserDetails> findByEmailOrPrimarycontactnum(String email, String primarycontactnum);
    EntityUserDetails save(EntityUserDetails userDetails);


}
