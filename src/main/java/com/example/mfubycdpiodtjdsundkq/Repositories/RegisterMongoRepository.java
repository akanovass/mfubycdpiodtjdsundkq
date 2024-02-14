package com.example.mfubycdpiodtjdsundkq.Repositories;

import com.example.mfubycdpiodtjdsundkq.entity.Register;
import com.example.mfubycdpiodtjdsundkq.entity.RegisterMongo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterMongoRepository extends MongoRepository<RegisterMongo, String> {
    List<RegisterMongo> findByNumOfPhoneOrNumOfPhoneSecond(String phoneNumb, String phoneNumbSecond);
    @Modifying
    void deleteByNumOfPhoneOrNumOfPhoneSecond(String phoneNumb, String phoneNumbSecond);

}
