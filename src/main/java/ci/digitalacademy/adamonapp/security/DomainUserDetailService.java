package ci.digitalacademy.adamonapp.security;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.models.User;
import ci.digitalacademy.adamonapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DomainUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Load user by username: {}", username);

        final Optional<User> user = userRepository.findByPseudo(username);

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found..." + username);
        }

        final List<GrantedAuthority> grantedAuthorities = user.get()
                .getRoles()
                .stream()
                .map(Role::getName)
//                .map(Role::getRole)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return user.map(userRecover -> org.springframework.security.core.userdetails.User.builder()
                .username(userRecover.getPseudo())
                .password(userRecover.getPassword())
                .disabled(userRecover.isActive())
                .authorities(grantedAuthorities)
                .build()).orElseThrow(() -> new IllegalArgumentException("User not found"));

    }

}
