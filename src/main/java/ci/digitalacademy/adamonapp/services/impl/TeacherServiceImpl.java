package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.School;
import ci.digitalacademy.adamonapp.models.Teacher;
import ci.digitalacademy.adamonapp.models.enumeration.Gender;
import ci.digitalacademy.adamonapp.repository.TeacherRepository;
import ci.digitalacademy.adamonapp.services.AddressService;
import ci.digitalacademy.adamonapp.services.TeacherService;
import ci.digitalacademy.adamonapp.services.dto.AddressDTO;
import ci.digitalacademy.adamonapp.services.dto.TeacherDTO;
import ci.digitalacademy.adamonapp.services.mapper.TeacherMapper;
import ci.digitalacademy.adamonapp.services.mapping.TeacherMapping;
import ci.digitalacademy.adamonapp.services.mapping.UserMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final AddressService addressService;

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        log.debug("Request to save school: {}", teacherDTO);
        Optional<AddressDTO> address = addressService.findOne(teacherDTO.getId());
        teacherDTO.setAddress(addressService.findById(teacherDTO.getAddress().getId()).orElse(null));
        if(address.isPresent()) {
            teacherDTO.setAddress(address.get());
        }
        teacherDTO.getAddress();
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {
        return findOne(teacherDTO.getId()).map(existingTeacher ->{
            Teacher teacher = teacherMapper.toEntity(teacherDTO);
            teacher.setLastName(teacherDTO.getLastName());
            teacher.setFirstName(teacherDTO.getFirstName());

            return save(existingTeacher);
        }).orElseThrow(()-> new RuntimeException("Teacher not found"));
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO, Long id) {
        teacherDTO.setId(id);
        return update(teacherDTO);
    }

    @Override
    public Optional<TeacherDTO> findOne(Long id) {
        return teacherRepository.findById(id).map(teacher -> teacherMapper.toDto(teacher));
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(teacherMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<TeacherDTO> findByfirstNameOrlastNameAndGender(String query, Gender gender) {
        List<Teacher> teachers = teacherRepository.findByFirstNameOrLastNameAndGender(query,query, gender);
        return teachers.stream().map(teacher -> teacherMapper.toDto(teacher)).toList();
    }

    @Override
    public Optional<TeacherDTO> findBySlug(String slug) {
        return teacherRepository.findBySlug(slug).map(teacherMapper::toDto);
    }

    @Override
    public TeacherDTO partialUpdate(TeacherDTO teacherDTO, Long id) {
        return teacherRepository.findById(id).map(teacher -> {
            TeacherMapping.partialUpdate(teacher, teacherDTO);
            return teacher;
        }).map(teacherRepository::save).map(teacherMapper::toDto).orElse(null);
    }

    @Override
    public Optional<TeacherDTO> findById(Long id) {
        return teacherRepository.findById(id).map(teacherMapper::toDto);
    }
}
