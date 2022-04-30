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

    private Boolean supprime;


}
