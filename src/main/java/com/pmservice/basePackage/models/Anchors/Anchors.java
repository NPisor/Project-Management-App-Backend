package com.pmservice.basePackage.models.Anchors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ar_earth_anchors")

public class Anchors {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Float latitude;

    @Column
    private Float longitude;

    @Column
    private Float altitude;

}
