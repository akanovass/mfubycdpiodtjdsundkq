package com.example.mfubycdpiodtjdsundkq.services.impl;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.DTO.RegisterMongoDTO;
import com.example.mfubycdpiodtjdsundkq.Repositories.RegisterMongoRepository;
import com.example.mfubycdpiodtjdsundkq.entity.Filter;
import com.example.mfubycdpiodtjdsundkq.entity.Register;

import com.example.mfubycdpiodtjdsundkq.entity.RegisterMongo;
import com.example.mfubycdpiodtjdsundkq.mapper.RegisterMongoMapper;
import com.example.mfubycdpiodtjdsundkq.services.RegisterMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegisterMongoServiceImpl implements RegisterMongoService {

    @Autowired
    private RegisterMongoRepository registerMongoRepository;

    @Autowired
    private RegisterMongoMapper registerMongoMapper;

//    @Override
//    public List<RegisterDTO> getRegisters() {
//        return registerMapper.toDTOList(registerRepository.findAll());
//    }

    @Override
    public RegisterMongoDTO getRegisterById(String id) {
        return registerMongoMapper.toDTO(registerMongoRepository.findById(id).orElse(null));
    }

    @Override
    public RegisterMongoDTO getRegisterByPhoneNumb(String phoneNumb) {
        List<RegisterMongo> registers = registerMongoRepository.findByNumOfPhoneOrNumOfPhoneSecond(phoneNumb, phoneNumb);
        if (registers.isEmpty()) {
            return null;
        }
        return registerMongoMapper.toDTO(registers.get(0));
    }

    @Override
    public void deleteRegisterById(String id) {
        registerMongoRepository.deleteById(id);

    }

    @Override
    public void deleteRegisterByPhoneNumb(String phoneNumb) {
        registerMongoRepository.deleteByNumOfPhoneOrNumOfPhoneSecond(phoneNumb, phoneNumb);

    }

    public List<RegisterMongoDTO> getRegistersByFilter(Filter filter) {
        Page<RegisterMongo> usersPage = registerMongoRepository.findAll(PageRequest.of(filter.getOffset(), filter.getLimit()));
        return registerMongoMapper.toDTOList(usersPage.getContent());
    }

    @Override
    public RegisterMongoDTO updateRegisterById(String id, RegisterMongoDTO register) {
        RegisterMongo checkRegister = registerMongoRepository.findById(id).orElse(null);
        if(checkRegister!=null){
            checkRegister.setName(register.getName());
            checkRegister.setDateOfBirth(register.getDateOfBirth());
            checkRegister.setNumOfPhone((register.getNumOfPhone()));
            checkRegister.setNumOfPhoneSecond(register.getNumOfPhoneSecond());

            return registerMongoMapper.toDTO(registerMongoRepository.save(checkRegister));
        }
        return null;
    }

    @Override
    public RegisterMongoDTO updateRegisterByPhoneNumb(String phoneNumb, RegisterMongoDTO register) {
        List<RegisterMongo> checkRegister = registerMongoRepository.findByNumOfPhoneOrNumOfPhoneSecond(phoneNumb, phoneNumb);
        if(checkRegister!=null){
            checkRegister.get(0).setName(register.getName());
            checkRegister.get(0).setDateOfBirth(register.getDateOfBirth());
            checkRegister.get(0).setNumOfPhone((register.getNumOfPhone()));
            checkRegister.get(0).setNumOfPhoneSecond(register.getNumOfPhoneSecond());

            return registerMongoMapper.toDTO(registerMongoRepository.save(checkRegister.get(0)));
        }
        return null;
    }

    @Override
    public RegisterMongoDTO addRegister(RegisterMongoDTO register) {
        RegisterMongo registerEntity = registerMongoMapper.toEntity(register);
        registerEntity.setCreatedDate(new Date());
        return registerMongoMapper.toDTO(registerMongoRepository.save(registerEntity));
    }



}
