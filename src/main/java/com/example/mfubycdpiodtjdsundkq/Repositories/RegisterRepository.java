package com.example.mfubycdpiodtjdsundkq.Repositories;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    Register findByNumOfPhoneOrNumOfPhoneSecond(String phoneNumb, String phoneNumbSecond);
}