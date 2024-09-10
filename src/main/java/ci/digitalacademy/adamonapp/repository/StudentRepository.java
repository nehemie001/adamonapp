package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
