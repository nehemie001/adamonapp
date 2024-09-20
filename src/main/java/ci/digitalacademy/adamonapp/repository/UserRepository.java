package ci.digitalacademy.adamonapp.repository;

import aj.org.objectweb.asm.commons.Remapper;
import ci.digitalacademy.adamonapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPseudo(String username);

    @Modifying
    @Query("UPDATE User u SET u.isActive = :isActive WHERE u.id = :id")
    void updateUserStatus(@Param("id") Long id, @Param("isActive") boolean isActive);

    Optional<User> findBySlug(String slug);
}
