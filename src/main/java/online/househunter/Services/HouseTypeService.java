package online.househunter.Services;

import online.househunter.Models.HouseType;
import online.househunter.Repositories.HouseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseTypeService {
    @Autowired
    private HouseTypeRepository houseTypeRepository;
    // Return all houseTypes
    public List<HouseType> getHouseTypes(){
        return houseTypeRepository.findAll();
    }

    // save new houseType
    public void save(HouseType houseType) {
        houseTypeRepository.save(houseType);
    }

    public HouseType edit(HouseType houseType) {
        houseTypeRepository.save(houseType);
        return houseType;
    }
    // get by id
    public Optional<HouseType> findById(Long id) {
        return houseTypeRepository.findById(id);
    }

    public void delete(Long id) {
        houseTypeRepository.deleteById(id);
    }
}
