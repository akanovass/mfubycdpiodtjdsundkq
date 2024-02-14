package com.example.mfubycdpiodtjdsundkq.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;




@Entity
@Table(name="t_register")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="dateOfBirth")
    private String dateOfBirth;

    @Column(name="numOfPhone")
    private int numOfPhone;

    @Column(name="numOfPhoneSecond")
    private int numOfPhoneSecond;

    @Column(name="createdDate")
    private Date createdDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }



}
