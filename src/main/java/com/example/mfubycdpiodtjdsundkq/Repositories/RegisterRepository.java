package com.example.mfubycdpiodtjdsundkq.Repositories;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.entity.Register;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface RegisterRepository extends JpaRepository<Register, Long> {
    List<Register> findByNumOfPhoneOrNumOfPhoneSecond(String phoneNumb, String phoneNumbSecond);
    @Modifying
    void deleteByNumOfPhoneOrNumOfPhoneSecond(String phoneNumb, String phoneNumbSecond);

}