package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.services.TeacherService;
import ci.digitalacademy.adamonapp.services.dto.TeacherDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/teachers")
public class TeacherRessource {

//    private final TeacherService teacherService;
//
//    @PostMapping
//    @ApiResponse(responseCode = "201", description = "Response to save teacher")
//    @Operation(summary = "save new teacher", description = "This endpoint allow to save teacher")
//    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO) {
//        log.debug("REST Request to save teacher: {}", teacherDTO);
//        return new ResponseEntity<>(teacherService.save(teacherDTO), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<TeacherDTO> updateTeacher(TeacherDTO teacherDTO, Long id) {
//
//        log.debug("REST Request to update teacher: {}", teacherDTO);
//        teacherService.update(teacherDTO, id);
//        return new ResponseEntity<>(teacherService.update(teacherDTO, id), HttpStatus.OK);
//    }
//
//    @GetMapping
//    public List<TeacherDTO> findAll(){
//        log.debug("REST Request to get all teacher");
//        return teacherService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    @ApiResponse(responseCode = "200", description = "Return a single teacher")
//    @Operation(summary = "Find a teacher by its id", description = "This endpoint allows to find a single")
//    public ResponseEntity<?> findById( @Parameter(required = true, description = "ID of the Teacher to be retrieved") @PathVariable Long id) {
//        log.debug("REST Request to get one teacher by id");
//        Optional<TeacherDTO> teacher = teacherService.findById(id);
//        if (teacher.isPresent()) {
//            return new ResponseEntity<>(teacher.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Teacher not found", HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/slug/{slug}")
//    @ApiResponse(responseCode = "200", description = "Return a teacher by its slug")
//    @Operation(summary = "Find a teacher by its slug", description = "This endpoint allows to find a teacher by its slug")
//    public ResponseEntity<TeacherDTO> findTeacherBySlug(
//            @Parameter(required = true, description = "Slug of the teacher to be retrieved")
//            @PathVariable String slug
//    ) {
//        log.debug("REST request to get teacher by slug : {}", slug);
//        Optional<TeacherDTO> teacher = teacherService.findBySlug(slug);
//        if (teacher.isPresent()) {
//            return new ResponseEntity<>(teacher.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
//        log.debug("REST Request to delete teacher: {}", id);
//        Optional<TeacherDTO> teacherDTO = teacherService.findOne(id);
//        if (teacherDTO.isPresent()){
//            return new ResponseEntity<>(teacherDTO.get(), HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>("Teacher not found", HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public TeacherDTO getTeacherById(@RequestBody TeacherDTO teacherDTO, @PathVariable Long id) {
//        log.debug("REST Request to update teacher: {} {}", teacherDTO, id);
//        return teacherService.update(teacherDTO, id);
//
//    }
//
//    @PatchMapping("/{id}")
//    public TeacherDTO partialUpdate(@RequestBody TeacherDTO teacherDTO, @PathVariable Long id) {
//        log.debug("REST Request to update teacher: {} {}", teacherDTO, id);
//        return teacherService.partialUpdate(teacherDTO, id);
//    }
}
