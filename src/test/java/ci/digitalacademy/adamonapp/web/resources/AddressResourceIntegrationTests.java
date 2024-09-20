package ci.digitalacademy.adamonapp.web.resources;

import ci.digitalacademy.adamonapp.services.AddressService;
import ci.digitalacademy.adamonapp.services.dto.AddressDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressResourceIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AddressService addressService;

    @Test
    void testCreateAddressAndCheckInDb() {

//        Arrange
        AddressDTO address = new AddressDTO(1L, "CIV", "tsss", "test", "test");

//        Act
        ResponseEntity<AddressDTO> response = restTemplate.postForEntity("/api/addresses", address, AddressDTO.class);

//        Assert
        assertEquals(HttpStatus.CREATED  , response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertEquals("CIV", response.getBody().getCountry());

//        Verify in database
        AddressDTO saveAddress = addressService.findOne(response.getBody().getId()).orElse(null);
        assertNotNull(saveAddress);
        assertEquals("CIV", saveAddress.getCountry());

    }
}
