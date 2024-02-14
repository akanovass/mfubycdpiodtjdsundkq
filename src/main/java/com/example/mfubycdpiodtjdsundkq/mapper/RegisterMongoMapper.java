package com.example.mfubycdpiodtjdsundkq.mapper;


import com.example.mfubycdpiodtjdsundkq.DTO.RegisterMongoDTO;
import com.example.mfubycdpiodtjdsundkq.entity.RegisterMongo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring")
public interface RegisterMongoMapper {
    RegisterMongoDTO toDTO(RegisterMongo register);
    RegisterMongo toEntity(RegisterMongoDTO registerDTO);

    List<RegisterMongoDTO> toDTOList(List<RegisterMongo> registers);
    List<RegisterMongo> toEntityList(List<RegisterMongoDTO> registersDTO);

}
