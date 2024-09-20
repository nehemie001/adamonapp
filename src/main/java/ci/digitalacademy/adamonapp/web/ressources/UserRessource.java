package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.services.UserService;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;
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
@RequestMapping("/api/users")
public class UserRessource {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        log.debug("REST Request to save user : {} ", userDTO);
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserDTO> findAll(){
        log.debug("REST Request to get all user");
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Return a single user")
    @Operation(summary = "Find a user by its id", description = "This endpoint allows to find a single")
    public ResponseEntity<?> findById( @Parameter(required = true, description = "ID of the sujet to be retrieved") @PathVariable Long id) {
        log.debug("REST Request to get one user by id");
        Optional<UserDTO> user = userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Setting not found", HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUse(@PathVariable Long id) {
        log.debug("REST Request to delete user: {}", id);
        Optional<UserDTO> userDTO = userService.findOne(id);
        if (userDTO.isPresent()){
            return new ResponseEntity<>(userDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Setting not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public UserDTO getUserById(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        log.debug("REST Request to update user: {} {}", userDTO, id);
        return userService.update(userDTO, id);

    }

    @PatchMapping("/{id}")
    public UserDTO partialUpdate(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        log.debug("REST Request to update users: {} {}", userDTO, id);
        return userService.partialUpdate(userDTO, id);
    }
}
