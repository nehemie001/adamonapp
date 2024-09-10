package ci.digitalacademy.adamonapp.services.dto;

import ci.digitalacademy.adamonapp.models.Address;
import ci.digitalacademy.adamonapp.models.User;
import ci.digitalacademy.adamonapp.models.enumeration.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String numbers;

    private String urlPicture;

    private Gender gender;

    private Address address;

    private User user;
}
