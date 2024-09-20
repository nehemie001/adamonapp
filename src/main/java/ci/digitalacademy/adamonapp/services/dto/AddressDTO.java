package ci.digitalacademy.adamonapp.services.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    private String country;

    private String city;

    private String street;

    private String slug;
}
