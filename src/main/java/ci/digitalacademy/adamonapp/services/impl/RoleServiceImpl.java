package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.repository.RoleRepository;
import ci.digitalacademy.adamonapp.services.RoleService;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import ci.digitalacademy.adamonapp.services.mapper.RoleMapper;
import ci.digitalacademy.adamonapp.services.mapping.RoleMapping;
import ci.digitalacademy.adamonapp.services.mapping.UserMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        log.debug("Request to save: {}", roleDTO);
        Role role = roleMapper.toEntity(roleDTO);
        role = roleRepository.save(role);
        return roleMapper.toDto(role);
    }

    @Override
    public RoleDTO update(RoleDTO roleDTO) {
        return findOne(roleDTO.getId()).map(existingUser -> {
            existingUser.setRole(roleDTO.getRole());
            existingUser.setSlug(roleDTO.getSlug());
            return save(existingUser);
        }).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public RoleDTO update(RoleDTO roleDTO, Long id) {
        roleDTO.setId(id);
        return update(roleDTO);
    }

    @Override
    public Optional<RoleDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<RoleDTO> initRoles(List<RoleDTO> roleUsers) {
        log.debug("Request to init roles {}", roleUsers);
        List<RoleDTO> roles = findAll();
        if (roles.isEmpty()){
            roleUsers.forEach(role->{
                save(role);
            });
        }
        return findAll();
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream().map(roleMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<RoleDTO> findByRole(String roleUser) {
        return roleRepository.findByRole(roleUser).stream().map(roleMapper::toDto).toList();
    }

    @Override
    public Optional<RoleDTO> findById(Long id) {
        log.debug("Request to get one role : {}", id);
        return roleRepository.findById(id).map(roleMapper::toDto);
    }

    @Override
    public Optional<RoleDTO> findBySlug(String slug) {
        log.debug("Request to get role by slug:{}", slug);
        return roleRepository.findBySlug(slug).map(roleMapper::toDto);
    }

    @Override
    public RoleDTO partialUpdate(RoleDTO roleDTO, Long id) {
        log.debug("Request to update a role specific", roleDTO, id);
        return roleRepository.findById(id).map(role -> {
            RoleMapping.partialUpdate(role, roleDTO);
            return role;
        }).map(roleRepository::save).map(roleMapper::toDto).orElse(null);
    }
}
