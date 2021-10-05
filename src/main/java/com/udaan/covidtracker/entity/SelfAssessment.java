package com.udaan.covidtracker.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SelfAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String userId;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> symptoms;

    @Column
    private boolean travelHistory;

    @Column
    private boolean contactWithCovidPatient;
}
