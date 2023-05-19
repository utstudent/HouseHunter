package online.househunter.Repositories;

import online.househunter.Models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query(value = "select i from Invoice i where " +
            "concat(i.remarks, i.client.name, i.invoiceStatus.description, i.paymentTerms, i.amountPayable) LIKE %?1%")
    List<Invoice> findByKeyword(String keyword);

}
