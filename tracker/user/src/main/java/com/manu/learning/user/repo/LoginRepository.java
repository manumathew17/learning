package com.manu.learning.user.repo;

import com.manu.learning.user.entity.EntityLoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface LoginRepository extends JpaRepository<EntityLoginRequest, Integer> {

    ArrayList<EntityLoginRequest> findByUsernameAndPassword(String username, String password);

}
