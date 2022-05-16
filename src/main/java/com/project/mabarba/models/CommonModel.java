package com.project.mabarba.models;


import com.fasterxml.jackson.annotation.JsonView;
import com.project.mabarba.helpers.Scope;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class CommonModel implements Serializable {

    protected String idCreator;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Scope.FirstLevel.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    protected Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Scope.FirstLevel.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    protected Date updatedAt;

    protected String idUpdatedBy;

    protected boolean deleted;

    protected Date deletedAt;

    public  CommonModel(){
        this.createdAt = new Date();
        this.deleted = false;
    }
    public String getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(String idCreator) {
        this.idCreator = idCreator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getIdUpdatedBy() {
        return idUpdatedBy;
    }

    public void setIdUpdatedBy(String idUpdatedBy) {
        this.idUpdatedBy = idUpdatedBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

}
