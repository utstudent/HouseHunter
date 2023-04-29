package online.househunter.Services;

import online.househunter.Models.EmployeeType;
import online.househunter.Repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
    // Return all employeeTypes
    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }

    // save new employeeType
    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public EmployeeType edit(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
        return employeeType;
    }
    // get by id
    public Optional<EmployeeType> findById(Long id) {
        return employeeTypeRepository.findById(id);
    }

    public void delete(Long id) {
        employeeTypeRepository.deleteById(id);
    }
}
