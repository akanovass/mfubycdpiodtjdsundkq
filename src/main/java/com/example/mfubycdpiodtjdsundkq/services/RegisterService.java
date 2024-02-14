package com.example.mfubycdpiodtjdsundkq.services;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;

import java.util.List;

public interface RegisterService {
    List<RegisterDTO> getRegisters();
    RegisterDTO getRegisterById(Long id);
    RegisterDTO getRegisterByPhoneNumb(String phoneNumb);

    RegisterDTO addRegister(RegisterDTO register);
    RegisterDTO update(RegisterDTO register);
    void deleteRegister(Long id);

}
