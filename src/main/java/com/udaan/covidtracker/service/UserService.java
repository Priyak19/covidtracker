package com.udaan.covidtracker.service;

import com.udaan.covidtracker.entity.SelfAssessment;
import com.udaan.covidtracker.entity.UserEntity;
import com.udaan.covidtracker.model.SelfAssessmentRequest;
import com.udaan.covidtracker.model.SelfAssessmentResponse;
import com.udaan.covidtracker.model.UserRequest;
import com.udaan.covidtracker.model.UserResponse;
import com.udaan.covidtracker.repository.SelfAssessmentRepository;
import com.udaan.covidtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SelfAssessmentRepository selfAssessmentRepository;

    public UserResponse registerUser(UserRequest userRequest){
        UserEntity userEntity = UserEntity.builder().mobileNumber(userRequest.getMobileNumber())
                .name(userRequest.getName())
                .pinCode(userRequest.getPinCode())
                .build();
        UserEntity entity = userRepository.save(userEntity);
        UserResponse userResponse = null;
        if (entity!=null){
            userResponse  = UserResponse.builder().userId(entity.getId().toString()).build();
        }
        return userResponse;
    }

    public SelfAssessmentResponse selfAssessment(SelfAssessmentRequest selfAssessmentRequest){
        SelfAssessment selfAssessment = SelfAssessment.builder()
                .contactWithCovidPatient(selfAssessmentRequest.isContactWithCovidPatient())
                .symptoms(selfAssessmentRequest.getSymptoms())
                .travelHistory(selfAssessmentRequest.isTravelHistory())
                .userId(selfAssessmentRequest.getUserId())
                .build();
        SelfAssessment entity = selfAssessmentRepository.save(selfAssessment);
        SelfAssessmentResponse selfAssessmentResponse = null;
        if (entity!=null){
            selfAssessmentResponse  = SelfAssessmentResponse.builder().riskPercentage(getPercentage(selfAssessmentRequest.getSymptoms())).build();
        }
        return selfAssessmentResponse;
    }

    private Integer getPercentage(List<String> symptoms) {
        if(symptoms.isEmpty()) {
            return 5;
        } else if (symptoms.size()==1) {
            return 50;
        } else if(symptoms.size()==2) {
            return 75;
        } else {
            return 95;
        }
    }

}
