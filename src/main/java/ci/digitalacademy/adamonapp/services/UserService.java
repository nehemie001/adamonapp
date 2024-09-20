package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    UserDTO update(UserDTO userDTO, Long id);

    Optional<UserDTO> findOne(Long id);

    List<UserDTO> findAll();

    void delete(Long id);

    void toggleUserStatus(Long id, boolean isActive);

    Optional<UserDTO>findById(Long id);

    Optional<UserDTO> findBySlug(String slug);

    UserDTO partialUpdate(UserDTO userDTO, Long id);
}
