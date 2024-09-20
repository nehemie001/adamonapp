package ci.digitalacademy.adamonapp.services.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String pseudo;

    private String password;

    private Instant creationDate;

    private boolean isActive;

    private String slug;

    private List<RoleDTO> role;

    private SchoolDTO school;
}
