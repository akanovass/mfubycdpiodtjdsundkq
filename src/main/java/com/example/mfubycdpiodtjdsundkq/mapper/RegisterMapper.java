package com.example.mfubycdpiodtjdsundkq.mapper;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.entity.Register;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegisterMapper {
    RegisterDTO toDTO(Register register);

    Register toEntity(RegisterDTO registerDTO);

    List<RegisterDTO> toDTOList(List<Register> registers);

    List<Register> toEntityList(List<RegisterDTO> registersDTO);

}
