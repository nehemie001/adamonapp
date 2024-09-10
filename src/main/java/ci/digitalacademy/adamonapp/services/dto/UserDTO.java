package ci.digitalacademy.adamonapp.services.dto;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.models.School;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String pseudo;

    private String password;

    private Date creation_date;

    private boolean isActive;

    private List<Role> role;

    private School school;
}
