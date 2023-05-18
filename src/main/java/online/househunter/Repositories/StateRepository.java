package online.househunter.Repositories;

import online.househunter.Models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    @Query(value = "select s from State s where " +
            "concat(s.name, s.capital, s.code) LIKE %?1%")
    List<State> findByKeyword(String keyword);
}
