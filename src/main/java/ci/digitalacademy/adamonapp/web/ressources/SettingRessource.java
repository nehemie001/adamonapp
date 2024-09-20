package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.services.SettingService;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;
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
@RequestMapping("/api/settings")
public class SettingRessource {

    private final SettingService settingService;

    @PostMapping
    public ResponseEntity<SettingDTO> saveSetting(@RequestBody SettingDTO settingDTO) {
        log.debug("REST Request to save setting : {} ", settingDTO);
        return new ResponseEntity<>(settingService.save(settingDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<SettingDTO> findAll(){
        log.debug("REST Request to get all setting");
        return settingService.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Return a single setting")
    @Operation(summary = "Find a setting by its id", description = "This endpoint allows to find a single")
    public ResponseEntity<?> findById( @Parameter(required = true, description = "ID of the sujet to be retrieved") @PathVariable Long id) {
        log.debug("REST Request to get one setting by id");
        Optional<SettingDTO> setting = settingService.findById(id);
        if (setting.isPresent()) {
            return new ResponseEntity<>(setting.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Setting not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a setting by its slug")
    @Operation(summary = "Find a setting by its slug", description = "This endpoint allows to find a setting by its slug")
    public ResponseEntity<SettingDTO> findSettingBySlug(
            @Parameter(required = true, description = "Slug of the setting to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get setting by slug : {}", slug);
        Optional<SettingDTO> setting = settingService.findBySlug(slug);
        if (setting.isPresent()) {
            return new ResponseEntity<>(setting.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSetting(@PathVariable Long id) {
        log.debug("REST Request to delete setting: {}", id);
        Optional<SettingDTO> settingDTO = settingService.findOne(id);
        if (settingDTO.isPresent()){
            return new ResponseEntity<>(settingDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Setting not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public SettingDTO getSettingById(@RequestBody SettingDTO settingDTO, @PathVariable Long id) {
        log.debug("REST Request to update setting: {} {}", settingDTO, id);
        return settingService.update(settingDTO, id);

    }

    @PatchMapping("/{id}")
    public SettingDTO partialUpdate(@RequestBody SettingDTO settingDTO, @PathVariable Long id) {
        log.debug("REST Request to update absence: {} {}", settingDTO, id);
        return settingService.partialUpdate(settingDTO, id);
    }

}
