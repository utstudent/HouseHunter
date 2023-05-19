package online.househunter.Services;

import online.househunter.Models.House;
import online.househunter.Repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;
    // Return all houses
    public List<House> getHouses(){
        return houseRepository.findAll();
    }

    // save new house
    public void save(House house) {
        houseRepository.save(house);
    }

    public House edit(House house) {
        houseRepository.save(house);
        return house;
    }
    // get by id
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    public void delete(Long id) {
        houseRepository.deleteById(id);
    }

    public List<House> findByKeyword(String keyword){
        return houseRepository.findByKeyword(keyword);
    }
}
