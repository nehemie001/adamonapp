package ci.digitalacademy.adamonapp.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationStudentDTO {

    private String firstName;
    private String lastName;
    private String matricule;
    private String email;
    private String country;
    private String city;
    private String street;
    private String pseudo;
}
