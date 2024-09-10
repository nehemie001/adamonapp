package ci.digitalacademy.adamonapp.repository;

import ci.digitalacademy.adamonapp.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
