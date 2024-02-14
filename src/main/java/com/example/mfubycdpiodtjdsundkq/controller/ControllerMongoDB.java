package com.example.mfubycdpiodtjdsundkq.controller;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterMongoDTO;
import com.example.mfubycdpiodtjdsundkq.entity.Filter;
import com.example.mfubycdpiodtjdsundkq.services.RegisterMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registerMongo")
public class ControllerMongoDB {

    @Autowired
    RegisterMongoService registerMongoService;


    @GetMapping("{id}")
    public RegisterMongoDTO getRegisterById( @PathVariable(name = "id") String id){
        return registerMongoService.getRegisterById(id);

    }

    @GetMapping
    public RegisterMongoDTO getRegisterByPhoneNumb(@RequestParam String phoneNumb) {
        return registerMongoService.getRegisterByPhoneNumb(phoneNumb);
    }

    @DeleteMapping("{id}")
    public void deleteRegisterById(@PathVariable(name = "id") String id) {
        registerMongoService.deleteRegisterById(id);
    }

    @DeleteMapping
    public void deleteRegisterByPhoneNumb(@RequestParam String phoneNumb) {
        registerMongoService.deleteRegisterByPhoneNumb(phoneNumb);
    }

    @GetMapping("/filter")
    public List<RegisterMongoDTO> getRegistersByFilter(@RequestBody Filter filter) {
        return registerMongoService.getRegistersByFilter(filter);
    }

    @PutMapping("/updateById/{id}")
    public RegisterMongoDTO updateUserById(@PathVariable String id, @RequestBody RegisterMongoDTO register) {
        return registerMongoService.updateRegisterById(id, register);
    }

    @PutMapping("/updateByPhoneNumb/{phoneNumb}")
    public RegisterMongoDTO updateUserByPhoneNumber(@PathVariable String phoneNumb, @RequestBody RegisterMongoDTO register) {
        return registerMongoService.updateRegisterByPhoneNumb(phoneNumb, register);
    }



}
