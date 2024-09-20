package ci.digitalacademy.adamonapp.web.ressources;

import ci.digitalacademy.adamonapp.services.AddressService;
import ci.digitalacademy.adamonapp.services.dto.AddressDTO;
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
@RequestMapping("/api/addresses")
public class AddressRessource {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDTO> saveAddress(@RequestBody AddressDTO addressDTO) {
        log.debug("REST Request to save address : {} ", addressDTO);
        return new ResponseEntity<>(addressService.save(addressDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<AddressDTO> findAll(){
        log.debug("REST Request to get all address");
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Return a single address")
    @Operation(summary = "Find a address by its id", description = "This endpoint allows to find a single")
    public ResponseEntity<?> findById( @Parameter(required = true, description = "ID of the sujet to be retrieved") @PathVariable Long id) {
        log.debug("REST Request to get one address by id");
        Optional<AddressDTO> address = addressService.findById(id);
        if (address.isPresent()) {
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Setting not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a address by its slug")
    @Operation(summary = "Find a address by its slug", description = "This endpoint allows to find a address by its slug")
    public ResponseEntity<AddressDTO> findSettingBySlug(
            @Parameter(required = true, description = "Slug of the address to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get address by slug : {}", slug);
        Optional<AddressDTO> address = addressService.findBySlug(slug);
        if (address.isPresent()) {
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSetting(@PathVariable Long id) {
        log.debug("REST Request to delete address: {}", id);
        Optional<AddressDTO> addressDTO = addressService.findOne(id);
        if (addressDTO.isPresent()){
            return new ResponseEntity<>(addressDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Setting not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public AddressDTO getSettingById(@RequestBody AddressDTO addressDTO, @PathVariable Long id) {
        log.debug("REST Request to update address: {} {}", addressDTO, id);
        return addressService.update(addressDTO, id);

    }

    @PatchMapping("/{id}")
    public AddressDTO partialUpdate(@RequestBody AddressDTO addressDTO, @PathVariable Long id) {
        log.debug("REST Request to update absence: {} {}", addressDTO, id);
        return addressService.partialUpdate(addressDTO, id);
    }
}
