package com.pmservice.basePackage.models.Task;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")

public class Task {

    @Id
    @Column
    private Long id;

    @Column
    private String message;

    @Column
    private Long assignerId;

    @Column
    private Long assigneeId;

    @Column
    private String taskDescription;

    @Column
    private Long priority;

    @Column
    private Timestamp createdTs;

    @Column
    private Timestamp taskSubmittedForReview;

    @Column
    private Timestamp taskCompleted;

    @Column
    private Long status;

    @Column
    private Long clientId;

}
