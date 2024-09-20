package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.models.User;
import ci.digitalacademy.adamonapp.repository.RoleRepository;
import ci.digitalacademy.adamonapp.repository.UserRepository;
import ci.digitalacademy.adamonapp.services.UserService;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;
import ci.digitalacademy.adamonapp.services.mapper.UserMapper;
import ci.digitalacademy.adamonapp.services.mapping.UserMapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save user: {}", userDTO);
        User user = userMapper.toEntity(userDTO);
//        user.setDateCreation(Instant.now());
        // Vérifier si la liste des rôles est null
        List<Role> roles = null;
        if (userDTO.getRole() != null && !userDTO.getRole().isEmpty()) {
            roles = new ArrayList<>();
            for (RoleDTO roleDTO : userDTO.getRole()) {
                Role role = roleRepository.findById(roleDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                roles.add(role);
            }
            // Associer les rôles à l'utilisateur
            user.setRoles(roles);
        }

        // Associer les rôles à l'utilisateur
        user.setRoles(roles);

        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        log.debug("Request to update user : {}", userDTO);
        return findOne(userDTO.getId()).map(existingUser -> {
            existingUser.setPseudo(userDTO.getPseudo());
            existingUser.setSlug(userDTO.getSlug());
            return save(existingUser);
        }).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long id) {

        userDTO.setId(id);
        return update(userDTO);
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        log.debug("Request to get user with id : {} ", id);
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public List<UserDTO> findAll() {
        log.debug("Request to get all users");
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete user : {}", id);
        userRepository.deleteById(id);
    }

    @Transactional
    public void toggleUserStatus(Long id, boolean isActive) {
        log.debug("Request to toggle user status : {} - {}", id, isActive);
        userRepository.updateUserStatus(id, isActive);
    }

    public Optional<UserDTO> findById(Long id) {
        log.debug("Request to find user with id : {} ", id);
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public Optional<UserDTO> findBySlug(String slug) {
        log.debug("Request to get user by slug:{}", slug);
        return userRepository.findBySlug(slug).map(userMapper::toDto);
    }

    @Override
    public UserDTO partialUpdate(UserDTO userDTO, Long id) {
        log.debug("Request to partial update user with id : {} ", id);
        return userRepository.findById(id).map(user -> {
            UserMapping.partialUpdate(user, userDTO);
            return user;
        }).map(userRepository::save).map(userMapper::toDto).orElse(null);
    }

}
