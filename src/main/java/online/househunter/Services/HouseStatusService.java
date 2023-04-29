package online.househunter.Services;

import online.househunter.Models.HouseStatus;
import online.househunter.Repositories.HouseStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseStatusService {
    @Autowired
    private HouseStatusRepository houseStatusRepository;
    // Return all houseStatus
    public List<HouseStatus> getHouseStatuses(){
        return houseStatusRepository.findAll();
    }

    // save new houseStatus
    public void save(HouseStatus houseStatus) {
        houseStatusRepository.save(houseStatus);
    }

    public HouseStatus edit(HouseStatus houseStatus) {
        houseStatusRepository.save(houseStatus);
        return houseStatus;
    }
    // get by id
    public Optional<HouseStatus> findById(Long id) {
        return houseStatusRepository.findById(id);
    }

    public void delete(Long id) {
        houseStatusRepository.deleteById(id);
    }
}
