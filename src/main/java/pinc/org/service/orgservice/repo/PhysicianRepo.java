package pinc.org.service.orgservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pinc.org.service.orgservice.model.Physician;

public interface PhysicianRepo extends JpaRepository<Physician, Long> {

}
