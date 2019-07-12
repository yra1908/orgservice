package pinc.org.service.orgservice.controler;

import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pinc.org.service.orgservice.model.Client;
import pinc.org.service.orgservice.repo.ClientRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/")
public class PingController {

    @Autowired
    private ClientRepo clientRepo;

    @RequestMapping(value = "clients", method = RequestMethod.GET)
    public List<Client> getClients() {
        Client cl1 = new Client();
        cl1.setName("name3");
        clientRepo.save(cl1);
        return clientRepo.findAll();
    }

    @RequestMapping(value = "addclients", method = RequestMethod.GET)
    public List<Client> saveClients() {
        Client cl1 = new Client();
        cl1.setName("name3");
        clientRepo.save(cl1);
        return clientRepo.findAll();
    }
}
