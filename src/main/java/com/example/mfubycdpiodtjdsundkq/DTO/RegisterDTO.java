package com.example.mfubycdpiodtjdsundkq.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    private Long id;
    private String name;
    private String dateOfBirth;
    private int numOfPhone;
    private int numOfPhoneSecond;
    private Date createdDate;
}