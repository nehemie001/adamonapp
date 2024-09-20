package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.Teacher;
import ci.digitalacademy.adamonapp.models.enumeration.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByFirstNameOrLastNameAndGender(String firstName, String lastName, Gender gender);

    Optional<Teacher> findBySlug(String slug);
}
