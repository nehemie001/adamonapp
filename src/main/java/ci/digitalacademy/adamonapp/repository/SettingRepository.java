package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {
}
