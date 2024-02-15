package com.example.mfubycdpiodtjdsundkq.controller;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.entity.Filter;
import com.example.mfubycdpiodtjdsundkq.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("register")
public class ControllerPostgreSQL {

    @Autowired
    private RegisterService registerService;


    @GetMapping("{id}")
    public RegisterDTO getRegisterById(@PathVariable(name = "id") Long id) {
        return registerService.getRegisterById(id);

    }

    @GetMapping
    public RegisterDTO getRegisterByPhoneNumb(@RequestParam String phoneNumb) {
        return registerService.getRegisterByPhoneNumb(phoneNumb);
    }

    @DeleteMapping("{id}")
    public void deleteRegisterById(@PathVariable(name = "id") Long id) {
        registerService.deleteRegisterById(id);
    }

    @DeleteMapping
    public void deleteRegisterByPhoneNumb(@RequestParam String phoneNumb) {
        registerService.deleteRegisterByPhoneNumb(phoneNumb);
    }

    @GetMapping("/filter")
    public List<RegisterDTO> getRegistersByFilter(@RequestBody Filter filter) {
        return registerService.getRegistersByFilter(filter);
    }

    @PutMapping("/updateById/{id}")
    public RegisterDTO updateUserById(@PathVariable Long id, @RequestBody RegisterDTO register) {
        return registerService.updateRegisterById(id, register);
    }

    @PutMapping("/updateByPhoneNumb/{phoneNumb}")
    public RegisterDTO updateUserByPhoneNumber(@PathVariable String phoneNumb, @RequestBody RegisterDTO register) {
        return registerService.updateRegisterByPhoneNumb(phoneNumb, register);
    }

}
