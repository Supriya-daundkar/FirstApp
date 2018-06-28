package com.vsplc.FirstApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractTimestampEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON", nullable = false)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_ON", nullable = false)
    private Date modifiedOn;

    @PrePersist
    protected void onCreate() {
    	modifiedOn = createdOn = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	modifiedOn = new Date();
    }
}