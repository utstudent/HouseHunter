package online.househunter.Models;

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
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "housetypeid", insertable = false, updatable = false)
    private HouseType houseType;
    private Long housetypeid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    private int sqft;
    private int bedrooms;
    private int bathrooms;
    private int stories;
    private int price;
    private int yearBuilt;
    private boolean hasGarage;
    private boolean hasPool;
    private boolean hasFireplace;
}
