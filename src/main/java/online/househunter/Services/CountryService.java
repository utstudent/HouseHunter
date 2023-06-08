package online.househunter.Services;

import online.househunter.Models.Country;
import online.househunter.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired private CountryRepository countryRepository;
    // Return all countries
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    // save new country
    public void save(Country country) {
        countryRepository.save(country);
    }

    public Country edit(Country country) {
        countryRepository.save(country);
        return country;
    }
    // get by id
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    public List<Country> findByKeyword(String keyword){
        return countryRepository.findByKeyword(keyword);
    }

}
