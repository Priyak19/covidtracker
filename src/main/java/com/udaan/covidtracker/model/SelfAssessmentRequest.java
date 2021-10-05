package com.udaan.covidtracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SelfAssessmentRequest {

    private String userId;

    private List<String> symptoms;

    private boolean travelHistory;

    private boolean contactWithCovidPatient;
}
