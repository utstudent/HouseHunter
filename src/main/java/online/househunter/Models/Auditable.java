package online.househunter.Models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@lombok.Setter
@lombok.Getter
public abstract class Auditable <U>{

    @Column(name = "created_by", updatable = false)
    @CreatedBy
    protected U createdBy;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @Column(name = "modified_by")
    @LastModifiedBy
    protected U lastModifiedBy;

    @Column(name = "modified_date")
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;


}
