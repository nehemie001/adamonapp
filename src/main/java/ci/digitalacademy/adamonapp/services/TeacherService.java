package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.models.enumeration.Gender;
import ci.digitalacademy.adamonapp.services.dto.TeacherDTO;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    TeacherDTO save(TeacherDTO teacherDTO);

    TeacherDTO update(TeacherDTO teacherDTO);

    TeacherDTO update(TeacherDTO teacherDTO, Long id);

    Optional<TeacherDTO> findOne(Long id);

    List<TeacherDTO> findAll();

    void delete(Long id);

    List<TeacherDTO> findByfirstNameOrlastNameAndGender(String query, Gender gender);

    Optional<TeacherDTO> findBySlug(String slug);

    TeacherDTO partialUpdate(TeacherDTO teacherDTO, Long id);

    Optional<TeacherDTO> findById(Long id);
}
