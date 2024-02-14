package com.example.mfubycdpiodtjdsundkq.controller;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("register")
public class ControllerPostgreSQL {

    @Autowired
    private RegisterService registerService;

    @GetMapping
    public List<RegisterDTO> allRegister(){
        return registerService.getRegisters();

    }
}
