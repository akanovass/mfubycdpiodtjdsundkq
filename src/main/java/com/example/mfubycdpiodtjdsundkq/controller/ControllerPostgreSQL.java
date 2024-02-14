package com.example.mfubycdpiodtjdsundkq.controller;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("register")
public class ControllerPostgreSQL {

    @Autowired
    private RegisterService registerService;

//    @GetMapping
//    public List<RegisterDTO> getAllRegister(){
//        return registerService.getRegisters();
//
//    }

    @GetMapping("{id}")
    public RegisterDTO getRegisterById( @PathVariable(name = "id") Long id){
        return registerService.getRegisterById(id);

    }

    @GetMapping
    public RegisterDTO getRegisterByPhoneNumb(@RequestParam String phoneNumb) {
        return registerService.getRegisterByPhoneNumb(phoneNumb);
    }

    @PostMapping
    public RegisterDTO addRegister(@RequestBody RegisterDTO register){
        return registerService.addRegister(register);

    }
}
