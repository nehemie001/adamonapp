package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    RoleDTO save(RoleDTO roleDTO);

    RoleDTO update(RoleDTO roleDTO);

    Optional<RoleDTO> findOne(Long id);

    List<RoleDTO> initRoles( List<RoleDTO> roleUsers);

    List<RoleDTO> findAll();

    void delete(Long id);
}
