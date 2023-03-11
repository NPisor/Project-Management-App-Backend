package com.pmservice.basePackage.models.Logins;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "logins")

public class Logins {

    @Id
    @Column
    private Long id;

    @Column
    private Long client;

    @Column
    private String username;

    @Column
    private String password;

}

