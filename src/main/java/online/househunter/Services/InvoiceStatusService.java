package online.househunter.Services;

import online.househunter.Models.InvoiceStatus;
import online.househunter.Repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;
    // Return all invoiceStatus
    public List<InvoiceStatus> getInvoiceStatuses(){
        return invoiceStatusRepository.findAll();
    }

    // save new invoiceStatus
    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public InvoiceStatus edit(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
        return invoiceStatus;
    }
    // get by id
    public Optional<InvoiceStatus> findById(Long id) {
        return invoiceStatusRepository.findById(id);
    }

    public void delete(Long id) {
        invoiceStatusRepository.deleteById(id);
    }
}
