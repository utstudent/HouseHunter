package online.househunter.Services;

import online.househunter.Models.Invoice;
import online.househunter.Repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    // Return all invoices
    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    // save new invoice
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public Invoice edit(Invoice invoice) {
        invoiceRepository.save(invoice);
        return invoice;
    }
    // get by id
    public Optional<Invoice> findById(Long id) {
        return invoiceRepository.findById(id);
    }

    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }
}
