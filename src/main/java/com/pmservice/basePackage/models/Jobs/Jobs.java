package com.pmservice.basePackage.models.Jobs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jobs")

public class Jobs {

    @Id
    @Column
    private Long id;

    @Column
    private Long client;

    @Column
    private String jobName;

}
