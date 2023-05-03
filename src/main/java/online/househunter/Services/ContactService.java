package online.househunter.Services;

import online.househunter.Models.Contact;
import online.househunter.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    // Return all contacts
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    // save new contact
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public Contact edit(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }
    // get by id
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
