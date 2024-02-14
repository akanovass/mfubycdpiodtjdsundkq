package com.example.mfubycdpiodtjdsundkq.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.annotation.Documented;
import java.util.Date;

@Document(collection="registers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMongo {
    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String dateOfBirth;

    @Field
    private String numOfPhone;

    @Field
    private String numOfPhoneSecond;

    @Field
    private Date createdDate;


}
