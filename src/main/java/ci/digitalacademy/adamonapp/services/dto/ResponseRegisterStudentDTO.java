package ci.digitalacademy.adamonapp.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRegisterStudentDTO {

    @JsonIgnoreProperties({"id", "phoneNumberFather", "studentCards", "birthday", "numbers", "urlPicture", "gender", "address", "user"})
    private StudentDTO student;

    @JsonIgnoreProperties({"id"})
    private AddressDTO address;

}
