package pinc.org.service.orgservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class OrgserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgserviceApplication.class, args);
	}

}
