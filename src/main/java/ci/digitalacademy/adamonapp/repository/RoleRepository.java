package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
