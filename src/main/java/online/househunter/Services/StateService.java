package online.househunter.Services;

import online.househunter.Models.State;
import online.househunter.Repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;
    // Return all states
    public List<State> getStates(){
        return stateRepository.findAll();
    }

    // save new state
    public void save(State state) {
        stateRepository.save(state);
    }

    public State edit(State state) {
        stateRepository.save(state);
        return state;
    }
    // get by id
    public Optional<State> findById(Long id) {
        return stateRepository.findById(id);
    }

    public void delete(Long id) {
        stateRepository.deleteById(id);
    }
}
