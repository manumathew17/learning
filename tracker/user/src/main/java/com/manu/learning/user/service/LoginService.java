package com.manu.learning.user.service;


import com.google.gson.Gson;
import com.manu.learning.user.entity.EntityLoginRequest;
import com.manu.learning.user.entity.EntityResponse;
import com.manu.learning.user.entity.EntityUserDetails;
import com.manu.learning.user.repo.LoginRepository;
import com.manu.learning.user.repo.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserRepository userRepository;

    public EntityResponse loginUser(EntityLoginRequest loginRequest) {
        EntityResponse response;
        Gson gson = new Gson();
        ArrayList<EntityLoginRequest> loginRequestArrayList;
        loginRequestArrayList = loginRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

        if (loginRequestArrayList.size() > 0) {
            EntityLoginRequest login = loginRequestArrayList.get(0);
            ArrayList<EntityUserDetails> userDetails = userRepository.findByEmail(login.getUsername());
            EntityUserDetails user = userDetails.get(0);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("firstname", user.getFirstname() != null ? user.getFirstname() : "none");
            jsonObject.put("lastname", user.getLastname() != null ? user.getLastname() : "none");
            jsonObject.put("email", user.getEmail() != null ? user.getEmail() : "none");
            jsonObject.put("primarycontactnum", user.getPrimarycontactnum() != null ? user.getPrimarycontactnum() : "none");
            jsonObject.put("secondarycontactnum", user.getSecondarycontactnum() != null ? user.getSecondarycontactnum() : "none");

            if (userDetails.size() > 0) {
                return response = new EntityResponse(200, "success", jsonObject.toString());
            } else {
                return response = new EntityResponse(400, "Can't find the user", gson.toJson(login));
            }
        } else {
            return response = new EntityResponse(400, "Invalid credential", gson.toJson(loginRequest.getUsername()));
        }


    }

}
