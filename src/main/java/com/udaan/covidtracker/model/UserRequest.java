package com.udaan.covidtracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRequest {

    private String name;
    private long mobileNumber;
    private String pinCode;
}
