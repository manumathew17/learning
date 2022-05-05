package com.manu.learning.user.service;

import com.manu.learning.user.entity.EntityResponse;
import com.manu.learning.user.entity.EntityUserDetails;
import com.manu.learning.user.entity.UserEntity;
import com.manu.learning.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public EntityResponse saveUser(UserEntity user) {
        EntityResponse response;
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());

        if (!matcher.matches()) {
            return response = new EntityResponse(400, "invalid mail pattern", user.getEmail());
        } else if (user.getPassword().length() < 5) {
            return response = new EntityResponse(400, "password must contain at least 5 characters", user.getPassword());
        } else if (user.getPrimarycontactnum().length() != 10) {
            return response = new EntityResponse(400, "enter 10 digit of phone number", user.getPrimarycontactnum());
        } else {
            ArrayList<EntityUserDetails> userRepositoryByEmail = userRepository.findByEmailOrPrimarycontactnum(user.getEmail(), user.getPrimarycontactnum());

            if (userRepositoryByEmail.size() > 0) {
                return response = new EntityResponse(400, "user already exists with email or primary contact number", user.getEmail());

            } else {
                EntityUserDetails userdata = new EntityUserDetails(user.getEmail(), user.getFirstname(), user.getLastname(), user.getLandmark(), user.getDistrict(),
                        user.getState(), user.getCountry(), user.getPrimarycontactnum(), user.getSecondarycontactnum(), UUID.nameUUIDFromBytes(user.getEmail().getBytes()).toString());
                EntityUserDetails userDetails = userRepository.save(userdata);
                if (userDetails != null) {
                    return response = new EntityResponse(200, "success", user.getEmail());

                } else {
                    return response = new EntityResponse(400, "unable to add user at moment", user.getEmail());
                }
            }

        }

    }

}
