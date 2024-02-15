package com.example.mfubycdpiodtjdsundkq;

import com.example.mfubycdpiodtjdsundkq.DTO.RegisterDTO;
import com.example.mfubycdpiodtjdsundkq.Repositories.RegisterRepository;
import com.example.mfubycdpiodtjdsundkq.entity.Register;
import com.example.mfubycdpiodtjdsundkq.mapper.RegisterMapper;
import com.example.mfubycdpiodtjdsundkq.services.impl.RegisterServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
public class MfubycdpiodtjdsundkqApplicationTests {

    @InjectMocks
    private RegisterServiceImpl registerService;

    @Mock
    private RegisterRepository registerRepository;

    @Mock
    private RegisterMapper registerMapper;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetRegisterById_WhenIdExists() {
        Long id = 1L;
        Register register = new Register();
        register.setId(id);

        RegisterDTO expectedDTO = new RegisterDTO();
        expectedDTO.setId(id);

        when(registerRepository.findById(id)).thenReturn(Optional.of(register));
        when(registerMapper.toDTO(register)).thenReturn(expectedDTO);

        RegisterDTO actualDTO = registerService.getRegisterById(id);

        Assert.assertEquals(actualDTO, expectedDTO);
        verify(registerRepository, times(1)).findById(id);
        verify(registerMapper, times(1)).toDTO(register);
    }

    @Test
    public void testGetRegisterById_WhenIdNotExists() {
        Long id = 1L;

        when(registerRepository.findById(id)).thenReturn(Optional.empty());

        RegisterDTO actualDTO = registerService.getRegisterById(id);

        Assert.assertNull(actualDTO);
        verify(registerRepository, times(1)).findById(id);
        verify(registerMapper, never()).toDTO(any());
    }
}
