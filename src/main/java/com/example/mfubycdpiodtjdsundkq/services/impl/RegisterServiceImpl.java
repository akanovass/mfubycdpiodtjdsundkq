package com.example.mfubycdpiodtjdsundkq.services.impl;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.Repositories.RegisterRepository;
import com.example.mfubycdpiodtjdsundkq.entity.Filter;
import com.example.mfubycdpiodtjdsundkq.entity.Register;
import com.example.mfubycdpiodtjdsundkq.mapper.RegisterMapper;
import com.example.mfubycdpiodtjdsundkq.services.RegisterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private RegisterMapper registerMapper;

//    @Override
//    public List<RegisterDTO> getRegisters() {
//        return registerMapper.toDTOList(registerRepository.findAll());
//    }

    @Override
    public RegisterDTO getRegisterById(Long id) {
        return registerMapper.toDTO(registerRepository.findById(id).orElse(null));
    }

    @Override
    public RegisterDTO getRegisterByPhoneNumb(String phoneNumb) {
        List<Register> registers = registerRepository.findByNumOfPhoneOrNumOfPhoneSecond(phoneNumb, phoneNumb);
        if (registers.isEmpty()) {
            return null;
        }
        return registerMapper.toDTO(registers.get(0));
    }

    @Override
    public void deleteRegisterById(Long id) {
        registerRepository.deleteById(id);

    }

    @Override
    public void deleteRegisterByPhoneNumb(String phoneNumb) {
        registerRepository.deleteByNumOfPhoneOrNumOfPhoneSecond(phoneNumb, phoneNumb);

    }

    public List<RegisterDTO> getRegistersByFilter(Filter filter) {
        Page<Register> usersPage = registerRepository.findAll(PageRequest.of(filter.getOffset(), filter.getLimit()));
        return registerMapper.toDTOList(usersPage.getContent());
    }

    @Override
    public RegisterDTO updateRegisterById(Long id, RegisterDTO register) {
        Register checkRegister = registerRepository.findById(id).orElse(null);
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
    public RegisterDTO updateRegisterByPhoneNumb(String phoneNumb, RegisterDTO register) {
        List<Register> checkRegister = registerRepository.findByNumOfPhoneOrNumOfPhoneSecond(phoneNumb, phoneNumb);
        if(checkRegister!=null){
            checkRegister.get(0).setName(register.getName());
            checkRegister.get(0).setDateOfBirth(register.getDateOfBirth());
            checkRegister.get(0).setNumOfPhone((register.getNumOfPhone()));
            checkRegister.get(0).setNumOfPhoneSecond(register.getNumOfPhoneSecond());

            return registerMapper.toDTO(registerRepository.save(checkRegister.get(0)));
        }
        return null;
    }

    @Override
    public RegisterDTO addRegister(RegisterDTO register) {
        Register registerEntity = registerMapper.toEntity(register);
        registerEntity.setCreatedDate(new Date());
            return registerMapper.toDTO(registerRepository.save(registerEntity));
    }






}
