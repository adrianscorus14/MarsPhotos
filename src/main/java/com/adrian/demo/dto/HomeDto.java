package com.adrian.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HomeDto {
    private String apiRoverData;
    private Integer marsSol;

    private Boolean cameraFhaz;
    private Boolean cameraRhaz;
    private Boolean cameraMast;
    private Boolean cameraChemcam;
    private Boolean cameraMahli;
    private Boolean cameraMardi;
    private Boolean cameraNavcam;
    private Boolean cameraPancam;
    private Boolean cameraMinites;

}
