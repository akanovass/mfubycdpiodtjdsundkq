package com.example.mfubycdpiodtjdsundkq.services.impl;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.Repositories.RegisterRepository;
import com.example.mfubycdpiodtjdsundkq.entity.Register;
import com.example.mfubycdpiodtjdsundkq.mapper.RegisterMapper;
import com.example.mfubycdpiodtjdsundkq.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public List<RegisterDTO> getRegisters() {
        return registerMapper.toDTOList(registerRepository.findAll());
    }

    @Override
    public RegisterDTO getRegisterById(Long id) {
        return registerMapper.toDTO(registerRepository.findById(id).orElseThrow());
    }

    @Override
    public RegisterDTO getRegisterByPhoneNumb(String phoneNumb) {
        return registerMapper.toDTO(registerRepository.findByNumOfPhoneOrNumOfPhoneSecond(phoneNumb, phoneNumb));
    }


    @Override
    public RegisterDTO addRegister(RegisterDTO register) {
        Register registerEntity = registerMapper.toEntity(register);
        registerEntity.setCreatedDate(new Date());
            return registerMapper.toDTO(registerRepository.save(registerEntity));
    }

    @Override
    public RegisterDTO update(RegisterDTO register) {
        Register checkRegister = registerRepository.findById(register.getId()).orElseThrow();
        if(checkRegister!=null){
            checkRegister.setName(register.getName());
            checkRegister.setDateOfBirth(register.getDateOfBirth());
            checkRegister.setNumOfPhone((register.getNumOfPhone()));
            checkRegister.setNumOfPhoneSecond(register.getNumOfPhoneSecond());

            return registerMapper.toDTO(registerRepository.save(checkRegister));
        }
        return null;
    }

    @Override
    public void deleteRegister(Long id) {

    }
}
