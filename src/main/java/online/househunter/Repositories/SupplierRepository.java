package online.househunter.Repositories;

import online.househunter.Models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(value = "select s from Supplier s where " +
            "concat(s.name, s.address, s.city, s.phone, s.email) LIKE %?1%")
    List<Supplier> findByKeyword(String keyword);
}
