package com.pmservice.basePackage.models.Usages;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usages")

public class Usages {

    @Id
    @Column
    private Long id;

    @Column
    private Long client;

    @Column
    private Long anchorsPlaced;

}
