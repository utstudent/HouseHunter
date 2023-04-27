package online.househunter.Services;

import online.househunter.Models.Location;
import online.househunter.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;
    // Return all locations
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    // save new location
    public void save(Location location) {
        locationRepository.save(location);
    }

    public Location edit(Location location) {
        locationRepository.save(location);
        return location;
    }
    // get by id
    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    public void delete(Long id) {
        locationRepository.deleteById(id);
    }
}
