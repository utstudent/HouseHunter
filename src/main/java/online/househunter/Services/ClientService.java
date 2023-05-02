package online.househunter.Services;

import online.househunter.Models.Client;
import online.househunter.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    // Return all clients
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    // save new client
    public void save(Client client) {
        clientRepository.save(client);
    }

    public Client edit(Client client) {
        clientRepository.save(client);
        return client;
    }
    // get by id
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
