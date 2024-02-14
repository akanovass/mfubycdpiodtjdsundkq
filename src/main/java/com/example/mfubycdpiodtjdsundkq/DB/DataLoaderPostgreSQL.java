package com.example.mfubycdpiodtjdsundkq.DB;


import com.example.mfubycdpiodtjdsundkq.Repositories.RegisterMongoRepository;
import com.example.mfubycdpiodtjdsundkq.Repositories.RegisterRepository;
import com.example.mfubycdpiodtjdsundkq.entity.Register;
import com.example.mfubycdpiodtjdsundkq.entity.RegisterMongo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataLoaderPostgreSQL {

    @Autowired
    private RegisterRepository registerRepository;

    @PostConstruct
    public void initData() {
        List<Register> list = new ArrayList<>();
        list.add(new Register(1L,"ShyrynPostgre","18-10-2002","87073912588","87073912466", new Date()));
        list.add(new Register(2L,"Aiganym","18-07-2002","87081223834","87075612699", new Date()));
        list.add(new Register(3L,"Bakyt","09-04-1998","87771211701","87073912498", new Date()));
        list.add(new Register(4L,"Berik","10-10-1999","87079393108","87073912475", new Date()));
        list.add(new Register(5L,"Aruzhan","12-03-2006","87086520354","87076667777", new Date()));
        list.add(new Register(6L,"Dias","24-11-2001","87001011613","87024441615", new Date()));
        list.add(new Register(7L,"Dimash","18-01-2000","87086521034","87786822347", new Date()));
        list.add(new Register(8L,"Rauan","29-02-2000","87089393209","87029393456", new Date()));
        list.add(new Register(9L,"Asel","18-03-2005","87071211908","87771241701", new Date()));
        list.add(new Register(10L,"Dana","01-01-2001","87021223835","87051223830", new Date()));

        registerRepository.saveAll(list);

    }
}