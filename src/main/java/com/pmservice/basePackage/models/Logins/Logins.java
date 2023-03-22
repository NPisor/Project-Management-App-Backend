package com.pmservice.basePackage.models.Logins;

import java.sql.Timestamp;

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

    @Column
    private Long failedAttempts;

    @Column
    private Timestamp lastLoginAttempt;

    @Column
    private Timestamp lastCredsChange;

}

