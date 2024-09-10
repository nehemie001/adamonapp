package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.services.StudentService;
import ci.digitalacademy.adamonapp.services.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentRessource {

    private final StudentService studentService;

    @PostMapping
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
        log.debug("REST Request to save{}", studentDTO);
        return studentService.save(studentDTO);
    }

    public StudentDTO updateStudent(StudentDTO studentDTO) {
        return null;
    }

    public StudentDTO getStudent(StudentDTO studentDTO) {
        return null;
    }

    public List<StudentDTO> getAllStudent() {
        return null;
    }
}
