package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.RegistrationStudentDTO;
import ci.digitalacademy.adamonapp.services.dto.ResponseRegisterStudentDTO;
import ci.digitalacademy.adamonapp.services.dto.StudentDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);

    StudentDTO uploadPictureStudent(Long id, MultipartFile picture) throws IOException;

    StudentDTO update(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO, Long id);

    Optional<StudentDTO> findOne(Long id);

    List<StudentDTO> findAll();

    void delete(Long id);

    ResponseRegisterStudentDTO registerStudent(RegistrationStudentDTO registrationStudentDTO);

    StudentDTO partialUpdate(StudentDTO studentDTO, Long id);

    Optional<StudentDTO> findBySlug(String slug);
}
