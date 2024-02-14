package com.example.mfubycdpiodtjdsundkq.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMongoDTO {
    private String id;
    private String name;
    private String dateOfBirth;
    private String numOfPhone;
    private String numOfPhoneSecond;
}