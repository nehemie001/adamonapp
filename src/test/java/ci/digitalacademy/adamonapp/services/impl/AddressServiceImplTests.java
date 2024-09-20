package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Address;
import ci.digitalacademy.adamonapp.repository.AddressRepository;
import ci.digitalacademy.adamonapp.services.AddressService;
import ci.digitalacademy.adamonapp.services.dto.AddressDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AddressServiceImplTests {

    @MockBean
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Test
    void whenFindById_thenReturnAddressNotEmpty() {

        when(addressRepository.findById(1L)).thenReturn(Optional.of(new Address(1L, "abidjan", "codody", "civ", "test"))); //Faire une simulation

        Optional<AddressDTO> address = addressService.findOne(1L);
        assertTrue(address.isPresent(), "Address must be present");
    }
}
