package com.example.mfubycdpiodtjdsundkq.services;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.entity.Filter;

import java.util.List;

public interface RegisterService {
    RegisterDTO getRegisterById(Long id);

    RegisterDTO getRegisterByPhoneNumb(String phoneNumb);

    void deleteRegisterById(Long id);

    void deleteRegisterByPhoneNumb(String phoneNumb);

    List<RegisterDTO> getRegistersByFilter(Filter filter);

    RegisterDTO updateRegisterById(Long id, RegisterDTO register);

    RegisterDTO updateRegisterByPhoneNumb(String phoneNumb, RegisterDTO register);

}
