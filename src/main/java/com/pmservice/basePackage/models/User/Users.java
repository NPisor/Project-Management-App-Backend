package com.pmservice.basePackage.models.User;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@JsonSerialize
@Table(name = "users")

public class Users {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String fName;

    @Column
    private String lName;

    @Column
    private Long role;

    @Column
    private Long client;

    @Column
    private String deviceId;

    @Column
    private Date createdOn;

    @Column
    private Date lastModified;

    @Column
    private Long tasksAssigned;

    @Column
    private Long tasksCompleted;

    @Column
    private Long tasksInReview;

}
