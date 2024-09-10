package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Student;
import ci.digitalacademy.adamonapp.models.Teacher;
import ci.digitalacademy.adamonapp.repository.StudentRepository;
import ci.digitalacademy.adamonapp.services.StudentService;
import ci.digitalacademy.adamonapp.services.dto.StudentDTO;
import ci.digitalacademy.adamonapp.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save school: {}", studentDTO);
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO, Long id) {
        return null;
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<StudentDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
