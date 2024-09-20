package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SettingRepository extends JpaRepository<Setting, Long> {
    Optional<Setting> findBySlug(String slug);
}
