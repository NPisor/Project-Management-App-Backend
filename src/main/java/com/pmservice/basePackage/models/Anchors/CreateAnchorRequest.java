package com.pmservice.basePackage.models.Anchors;

import lombok.Data;

@Data
public class CreateAnchorRequest {

    private Long id;

    private Float longitude;

    private Float latitude;

    private Float altitude;
    
}
