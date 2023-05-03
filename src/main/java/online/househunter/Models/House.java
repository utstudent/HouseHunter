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
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "housetypeid", insertable = false, updatable = false)
    private HouseType houseType;
    private Long housetypeid;

    private String houseNumber;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date marketEntryDate;

    @ManyToOne
    @JoinColumn(name = "housestatusid", insertable = false, updatable = false)
    private HouseStatus houseStatus;
    private Long housestatusid;

    @ManyToOne
    @JoinColumn(name = "employeeid", insertable = false, updatable = false)
    private Employee inCharge;
    private Long employeeid;

    @OneToOne
    @JoinColumn(name = "locationid", insertable = false, updatable = false)
    private Location location;
    private Long locationid;

    private String description;
    private int sqrft;
    private int bedroom;
    private int bathroom;
    private int stories;
    private int price;
    private int yearBuilt;
    private boolean hasGarage;
    private boolean hasPool;
    private boolean hasFireplace;

}
