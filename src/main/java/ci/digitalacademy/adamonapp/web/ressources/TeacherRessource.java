package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.models.Teacher;
import ci.digitalacademy.adamonapp.services.TeacherService;
import ci.digitalacademy.adamonapp.services.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/teachers")
public class TeacherRessource {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        log.debug("REST Request to save teacher: {}", teacherDTO);
        return new ResponseEntity<>(teacherService.save(teacherDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(TeacherDTO teacherDTO, Long id) {
        log.debug("REST Request to update teacher: {}", teacherDTO);
        teacherService.update(teacherDTO, id);
        return new ResponseEntity<>(teacherService.update(teacherDTO, id), HttpStatus.OK);
    }
}
