package pinc.org.service.orgservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pinc.org.service.orgservice.model.Client;


public interface ClientRepo extends JpaRepository<Client, Long> {

}
