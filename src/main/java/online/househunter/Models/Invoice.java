package online.househunter.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;

    private float amountPayable;

    //    @Column(columnDefinition = "integer default 30")
//    @Column(name="payment_terms", columnDefinition="Decimal(10,2) default '100.00'")
//    @ColumnDefault("30")
    private Integer paymentTerms;

    @ManyToOne
    @JoinColumn(name = "invoicestatusid", insertable = false, updatable = false)
    private InvoiceStatus invoiceStatus;
    private Long invoicestatusid;

    @ManyToOne
    @JoinColumn(name = "clientid", insertable = false, updatable = false)
    private Client client;
    private Long clientid;

    private String remarks;
}
