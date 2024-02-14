package com.example.mfubycdpiodtjdsundkq.services;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.DTO.RegisterMongoDTO;
import com.example.mfubycdpiodtjdsundkq.entity.Filter;

import java.util.List;

public interface RegisterMongoService {
    RegisterMongoDTO getRegisterById(String id);
    RegisterMongoDTO getRegisterByPhoneNumb(String phoneNumb);
    void deleteRegisterById(String id);
    void deleteRegisterByPhoneNumb(String phoneNumb);
    List<RegisterMongoDTO> getRegistersByFilter(Filter filter);
    RegisterMongoDTO updateRegisterById(String id, RegisterMongoDTO register);
    RegisterMongoDTO updateRegisterByPhoneNumb(String phoneNumb, RegisterMongoDTO register);

    RegisterMongoDTO addRegister(RegisterMongoDTO register);

}
