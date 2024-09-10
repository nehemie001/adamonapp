package ci.digitalacademy.adamonapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false , name = "name")
    private String name;

    @Column(nullable = false , name = "url_logo")
    private String urlLogo;

    @OneToOne
    private Setting setting;
}
