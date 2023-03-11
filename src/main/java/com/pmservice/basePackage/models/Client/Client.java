package com.pmservice.basePackage.models.Client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clients")

public class Client {

    @Id
    @Column
    private Long id;

    @Column
    private String clientName;

}
