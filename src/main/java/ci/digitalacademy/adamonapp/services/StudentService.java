package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO, Long id);

    Optional<StudentDTO> findOne(Long id);

    List<StudentDTO> findAll();

    void delete(Long id);
}
