package ci.digitalacademy.adamonapp.services.dto;

import ci.digitalacademy.adamonapp.models.Setting;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolDTO {

    private Long id;

    private String name;

    private String urlLogo;

    private Setting setting;
}
