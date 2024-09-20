package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.services.SchoolService;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;
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
@RequestMapping("/api/schools")
public class SchoolRessource {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<SchoolDTO> saveSchool(@RequestBody SchoolDTO schoolDTO) {
        log.debug("REST Request to save school : {} ", schoolDTO);
        return new ResponseEntity<>(schoolService.save(schoolDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<SchoolDTO> findAll(){
        log.debug("REST Request to get all school");
        return schoolService.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Return a single school")
    @Operation(summary = "Find a school by its id", description = "This endpoint allows to find a single")
    public ResponseEntity<?> findById( @Parameter(required = true, description = "ID of the school to be retrieved") @PathVariable Long id) {
        log.debug("REST Request to get one school by id");
        Optional<SchoolDTO> school = schoolService.findById(id);
        if (school.isPresent()) {
            return new ResponseEntity<>(school.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("School not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable Long id) {
        log.debug("REST Request to delete school: {}", id);
        Optional<SchoolDTO> schoolDTO = schoolService.findOne(id);
        if (schoolDTO.isPresent()){
            return new ResponseEntity<>(schoolDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("school not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public SchoolDTO getSchoolById(@RequestBody SchoolDTO schoolDTO, @PathVariable Long id) {
        log.debug("REST Request to update school: {} {}", schoolDTO, id);
        return schoolService.update(schoolDTO, id);

    }

    @PatchMapping("/{id}")
    public SchoolDTO partialUpdate(@RequestBody SchoolDTO schoolDTO, @PathVariable Long id) {
        log.debug("REST Request to update absence: {} {}", schoolDTO, id);
        return schoolService.partialUpdate(schoolDTO, id);
    }
}
