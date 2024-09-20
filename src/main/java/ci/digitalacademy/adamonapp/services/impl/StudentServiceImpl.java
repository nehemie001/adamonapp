package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Student;
import ci.digitalacademy.adamonapp.repository.StudentRepository;
import ci.digitalacademy.adamonapp.security.AuthorityConstants;
import ci.digitalacademy.adamonapp.services.*;
import ci.digitalacademy.adamonapp.services.dto.*;
import ci.digitalacademy.adamonapp.services.mapper.StudentMapper;
import ci.digitalacademy.adamonapp.services.mapping.StudentMapping;
import java.io.IOException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final AddressService addressService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;
    private final FileStorageService fileStorageService;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save school: {}", studentDTO);
        Optional<AddressDTO> address = addressService.findOne(studentDTO.getId());
        studentDTO.setAddress(addressService.findById(studentDTO.getAddress().getId()).orElse(null));
        if (address.isPresent()) {
            studentDTO.setAddress(address.get());
        }
        studentDTO.getAddress();
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDTO uploadPictureStudent(Long id, MultipartFile picture) throws IOException {

        Optional<StudentDTO> one = findOne(id);
        StudentDTO student = one.orElse(null);
        if(student != null) {
            String upload = fileStorageService.upload(picture);
            student.setPicture(upload);
            save(student);
        }
        return student;
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
        return studentRepository.findById(id).map(studentMapper::toDto);
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(studentMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public ResponseRegisterStudentDTO registerStudent(RegistrationStudentDTO registrationStudentDTO) {
        log.debug("Request to register student: {}", registrationStudentDTO);
        AddressDTO address = modelMapper.map(registrationStudentDTO, AddressDTO.class);
        address = addressService.save(address);

        List<RoleDTO> roles = roleService.findByRole(AuthorityConstants.ROLE_USER);
        UserDTO user = modelMapper.map(registrationStudentDTO, UserDTO.class);
        String password = UUID.randomUUID().toString();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRole(roles);
        user = userService.save(user);

        StudentDTO student = modelMapper.map(registrationStudentDTO, StudentDTO.class);
        student.setUser(user);
        student.setAddress(address);
        student = save(student);

        ResponseRegisterStudentDTO response = new ResponseRegisterStudentDTO();
        response.setStudent(student);
        response.setAddress(address);
        return response;
    }

    public StudentDTO partialUpdate(StudentDTO studentDTO, Long id) {
        return studentRepository.findById(id).map(student -> {
            StudentMapping.partialUpdate(student, studentDTO);
            return student;
        }).map(studentRepository::save).map(studentMapper::toDto).orElse(null);
    }

    @Override
    public Optional<StudentDTO> findBySlug(String slug) {
        log.debug("Request to get setting by slug:{}", slug);
        return studentRepository.findBySlug(slug).map(studentMapper::toDto);
    }
}
