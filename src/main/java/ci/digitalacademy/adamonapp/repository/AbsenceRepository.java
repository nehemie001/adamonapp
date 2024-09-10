package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
