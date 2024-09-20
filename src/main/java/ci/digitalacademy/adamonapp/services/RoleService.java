package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleService {

    RoleDTO save(RoleDTO roleDTO);

    RoleDTO update(RoleDTO roleDTO);

    RoleDTO update(RoleDTO roleDTO, Long id);

    Optional<RoleDTO> findOne(Long id);

    List<RoleDTO> initRoles( List<RoleDTO> roleUsers);

    List<RoleDTO> findAll();

    void delete(Long id);

    List<RoleDTO> findByRole(String roleUser);

    Optional<RoleDTO> findById(Long id);

    Optional<RoleDTO> findBySlug(String slug);

    RoleDTO partialUpdate(RoleDTO roleDTO, Long id);
}
