package ci.digitalacademy.adamonapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "absence")
@ToString
public class Absence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "absence_date")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Instant absenceDate;

    @Column(name = "absence_number")
    private String absenceNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @Column(name = "slug", unique = true)
    private String slug;

}
