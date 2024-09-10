package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.models.User;
import ci.digitalacademy.adamonapp.repository.RoleRepository;
import ci.digitalacademy.adamonapp.repository.UserRepository;
import ci.digitalacademy.adamonapp.services.UserService;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;
import ci.digitalacademy.adamonapp.services.mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        log.debug("Request to save user: {}", userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDTO update(UserDTO user) {
        return null;
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {

    }

    @Transactional
    public void toggleUserStatus(Long id, boolean isActive) {
        userRepository.updateUserStatus(id, isActive);
    }

    public UserDTO findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }

}
