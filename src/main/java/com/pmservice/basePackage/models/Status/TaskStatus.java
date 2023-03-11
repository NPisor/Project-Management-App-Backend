package com.pmservice.basePackage.models.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "task_status")

public class TaskStatus {

    @Id
    @Column
    private Long id;

    @Column
    private String description;

}
