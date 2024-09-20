package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findBySlug(String slug);
}
