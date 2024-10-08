package ci.digitalacademy.adamonapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "setting")
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "smtp_server", nullable = false)
    private String smtpServer;

    @Column(name = "smtp_port", nullable = false)
    private Long smtpPort;

    @Column(name = "smtp_username", nullable = false)
    private String smtpUsername;

    @Column(unique = true, nullable = false , name = "smtp_password")
    private String smtpPassword;

    @Column(name = "slug", unique = true)
    private String slug;

    @OneToOne(mappedBy = "setting")
    private School school;
}
