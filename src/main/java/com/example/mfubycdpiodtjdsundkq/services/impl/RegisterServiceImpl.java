package com.example.mfubycdpiodtjdsundkq.services.impl;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.Repositories.RegisterRepository;
import com.example.mfubycdpiodtjdsundkq.mapper.RegisterMapper;
import com.example.mfubycdpiodtjdsundkq.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public RegisterDTO getRegister(Long id) {
        return registerMapper.toDTO(registerRepository.findById(id).orElseThrow());
    }

    @Override
    public RegisterDTO addRegister(RegisterDTO register) {
        return null;
    }

    @Override
    public RegisterDTO update(RegisterDTO register) {

        return null;
    }

    @Override
    public void deleteRegister(Long id) {

    }
}
