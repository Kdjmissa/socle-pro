/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.entity;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Assima
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class MappedEntity implements Serializable {

    @CreatedDate
    @Column(name = "created_date", nullable = true)
    protected Instant createdDate = Instant.now();
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    public MappedEntity() {
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @PrePersist
    public void initCreatedDate() {
        setCreatedDate(Instant.now());
        setLastModifiedDate(Instant.now());
    }

    @PreUpdate
    public void initLastModifieddDate() {
        setLastModifiedDate(Instant.now());
    }

    public MappedEntity(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
