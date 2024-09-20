package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.services.AbsenceService;
import ci.digitalacademy.adamonapp.services.dto.AbsenceDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/absences")
@Slf4j
@RequiredArgsConstructor
public class AbsenceRessource {

    private final AbsenceService absenceService;

    @PostMapping
    public ResponseEntity<AbsenceDTO> save(@RequestBody AbsenceDTO absenceDTO) {
        log.debug("REST Request to save a absence: {}", absenceDTO);
        return new ResponseEntity<>(absenceService.save(absenceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public AbsenceDTO getAbsenceById(@RequestBody AbsenceDTO absenceDTO, @PathVariable Long id) {
        log.debug("REST Request to update absence: {} {}", absenceDTO, id);
       return absenceService.update(absenceDTO, id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        log.debug("REST Request to get one absence: {}", id);
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAbsence(@PathVariable Long id) {
        log.debug("REST Request to delete absence: {}", id);
        Optional<AbsenceDTO> absenceDTO = absenceService.findOne(id);
        if (absenceDTO.isPresent()){
            return new ResponseEntity<>(absenceDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Absence not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<AbsenceDTO> getAllAbsences() {
        log.debug("REST Request to get all absences");
        return absenceService.findAll();
    }

    @PatchMapping("/{id}")
    public AbsenceDTO partialUpdate(@RequestBody AbsenceDTO absenceDTO, @PathVariable Long id) {
        log.debug("REST Request to update absence: {} {}", absenceDTO, id);
        return absenceService.partialUpdate(absenceDTO, id);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getOneBySlug(@PathVariable String slug) {
        log.debug("REST Request to get one absence by slug: {}", slug);
        return null;
    }
}
