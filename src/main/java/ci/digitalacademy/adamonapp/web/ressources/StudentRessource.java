package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.services.StudentService;
import ci.digitalacademy.adamonapp.services.dto.FileStudentDTO;
import ci.digitalacademy.adamonapp.services.dto.RegistrationStudentDTO;
import ci.digitalacademy.adamonapp.services.dto.ResponseRegisterStudentDTO;
import ci.digitalacademy.adamonapp.services.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentRessource {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
        log.debug("REST Request to save  {}", studentDTO);
        return new ResponseEntity<>(studentService.save(studentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent( @RequestBody StudentDTO studentDTO, @PathVariable Long id){
        log.debug(" REST Request to update  {}", studentDTO);
        return new ResponseEntity<>(studentService.update(studentDTO, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        log.debug(" REST Request to get one  ");
        Optional<StudentDTO> studentDTO = studentService.findOne(id);
        if (studentDTO.isPresent()) {
            return new ResponseEntity<>(studentDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<StudentDTO> getAllStudent(){
        log.debug("REST Request to all student ");
        return studentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        log.debug("REST Request to delete  ");
        studentService.delete(id);
    }

    @PostMapping("/register-student")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseRegisterStudentDTO registerStudent(@RequestBody RegistrationStudentDTO registrationStudentDTO) {
        log.debug("REST Request to register student : {}", registrationStudentDTO);
        return studentService.registerStudent(registrationStudentDTO);
    }

    @PatchMapping("/{id}")
    public StudentDTO partialUpdate(@RequestBody StudentDTO studentDTO, @PathVariable Long id) {
        log.debug("REST Request to update users: {} {}", studentDTO, id);
        return studentService.partialUpdate(studentDTO, id);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPictureStudent(@ModelAttribute FileStudentDTO fileStudentDTO) throws IOException {
        StudentDTO studentDTO = studentService.uploadPictureStudent(fileStudentDTO.getId(), fileStudentDTO.getFile());
        if(studentDTO != null) {
            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("student not found", HttpStatus.NOT_FOUND);
        }
    }
}
