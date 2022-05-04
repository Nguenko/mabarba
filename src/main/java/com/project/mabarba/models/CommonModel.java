package com.project.mabarba.models;


import com.fasterxml.jackson.annotation.JsonView;
import com.project.mabarba.helpers.Scope;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class CommonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Scope.FirstLevel.class)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Scope.FirstLevel.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Scope.FirstLevel.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dateModification;

    protected boolean deleted;

    public CommonModel(){
        this.dateCreation = new Date();
        this.deleted = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
