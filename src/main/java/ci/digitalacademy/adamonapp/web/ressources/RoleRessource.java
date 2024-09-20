package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.services.RoleService;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
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
@RequestMapping("/api/roles")
public class RoleRessource {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleDTO> saveSetting(@RequestBody RoleDTO roleDTO) {
        log.debug("REST Request to save user : {} ", roleDTO);
        return new ResponseEntity<>(roleService.save(roleDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<RoleDTO> findAll(){
        log.debug("REST Request to get all user");
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Return a single user")
    @Operation(summary = "Find a user by its id", description = "This endpoint allows to find a single")
    public ResponseEntity<?> findById( @Parameter(required = true, description = "ID of the sujet to be retrieved") @PathVariable Long id) {
        log.debug("REST Request to get one user by id");
        Optional<RoleDTO> user = roleService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Setting not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a user by its slug")
    @Operation(summary = "Find a user by its slug", description = "This endpoint allows to find a user by its slug")
    public ResponseEntity<RoleDTO> findSettingBySlug(
            @Parameter(required = true, description = "Slug of the user to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get user by slug : {}", slug);
        Optional<RoleDTO> user = roleService.findBySlug(slug);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSetting(@PathVariable Long id) {
        log.debug("REST Request to delete user: {}", id);
        Optional<RoleDTO> roleDTO = roleService.findOne(id);
        if (roleDTO.isPresent()){
            return new ResponseEntity<>(roleDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Setting not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public RoleDTO getSettingById(@RequestBody RoleDTO roleDTO, @PathVariable Long id) {
        log.debug("REST Request to update user: {} {}", roleDTO, id);
        return roleService.update(roleDTO, id);

    }

    @PatchMapping("/{id}")
    public RoleDTO partialUpdate(@RequestBody RoleDTO roleDTO, @PathVariable Long id) {
        log.debug("REST Request to update users: {} {}", roleDTO, id);
        return roleService.partialUpdate(roleDTO, id);
    }
}
