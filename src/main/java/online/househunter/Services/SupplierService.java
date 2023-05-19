package online.househunter.Services;

import online.househunter.Models.Supplier;
import online.househunter.Repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    // Return all suppliers
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    // save new supplier
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public Supplier edit(Supplier supplier) {
        supplierRepository.save(supplier);
        return supplier;
    }
    // get by id
    public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }

    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

    public List<Supplier> findByKeyword(String keyword){
        return supplierRepository.findByKeyword(keyword);
    }
}
