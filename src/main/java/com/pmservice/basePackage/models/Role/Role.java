package com.pmservice.basePackage.models.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_roles")

public class Role {

    @Id
    @Column
    private Long id;

    @Column
    private String label;

    @Column
    private Long group;

    @Column
    private Long clientId;

}
