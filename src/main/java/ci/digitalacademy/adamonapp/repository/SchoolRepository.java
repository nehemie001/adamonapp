package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
