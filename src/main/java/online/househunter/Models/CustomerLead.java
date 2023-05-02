package online.househunter.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CustomerLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
    private String mobile;
    private String remarks;
    private String email;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "customerleadstatusid", insertable = false, updatable = false)
    private CustomerLeadStatus customerLeadStatus;
    private Long customerleadstatusid;
}
