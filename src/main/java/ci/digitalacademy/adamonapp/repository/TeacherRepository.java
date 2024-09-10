package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByFirstNameOrLastNameAndGender(String firstName, String lastName, String gender);
}
