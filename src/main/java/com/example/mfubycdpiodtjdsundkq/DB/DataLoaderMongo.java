package com.example.mfubycdpiodtjdsundkq.DB;


import com.example.mfubycdpiodtjdsundkq.Repositories.RegisterMongoRepository;
import com.example.mfubycdpiodtjdsundkq.entity.RegisterMongo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataLoaderMongo {

    @Autowired
    private RegisterMongoRepository registerMongoRepository;

    @PostConstruct
    public void initData() {

        List<RegisterMongo> list = new ArrayList<>();
        list.add(new RegisterMongo("1","Shyryn","18-10-2002","87073912588","87073912466", new Date()));
        list.add(new RegisterMongo("2","Aiganym","18-07-2002","87081223834","87075612699", new Date()));
        list.add(new RegisterMongo("3","Bakyt","09-04-1998","87771211701","87073912498", new Date()));
        list.add(new RegisterMongo("4","Berik","10-10-1999","87079393108","87073912475", new Date()));
        list.add(new RegisterMongo("5","Aruzhan","12-03-2006","87086520354","87076667777", new Date()));
        list.add(new RegisterMongo("6","Dias","24-11-2001","87001011613","87024441615", new Date()));
        list.add(new RegisterMongo("7","Dimash","18-01-2000","87086521034","87786822347", new Date()));
        list.add(new RegisterMongo("8","Rauan","29-02-2000","87089393209","87029393456", new Date()));
        list.add(new RegisterMongo("9","Asel","18-03-2005","87071211908","87771241701", new Date()));
        list.add(new RegisterMongo("10","Dana","01-01-2001","87021223835","87051223830", new Date()));

        registerMongoRepository.saveAll(list);

    }
}