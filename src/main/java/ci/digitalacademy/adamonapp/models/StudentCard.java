package ci.digitalacademy.adamonapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_cards")
@ToString
public class StudentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStudentCard;

    @Column(nullable = false , name = "reference")
    private String reference;

    @Column(nullable = false , name = "issue_date")
    private Date issueDate;

    @Column(nullable = false , name = "expired_date")
    private Date expiredDate;

    @ManyToOne
    private Student student;
}
