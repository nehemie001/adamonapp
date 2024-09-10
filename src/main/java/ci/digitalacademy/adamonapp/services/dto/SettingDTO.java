package ci.digitalacademy.adamonapp.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingDTO {

    private Long id;

    private String smtpServer;

    private Long smtpPort;

    private String smtpUsername;

    private String smtpPassword;

}
