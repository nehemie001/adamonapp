package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.repository.RoleRepository;
import ci.digitalacademy.adamonapp.services.RoleService;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import ci.digitalacademy.adamonapp.services.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return null;
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
}
