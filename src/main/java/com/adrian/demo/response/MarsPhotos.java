package com.adrian.demo.response;


import com.adrian.demo.response.Camera;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class MarsPhotos {

    private Long id;
    private Integer sol;
    private Camera camera;

    @JsonProperty("img_src")
    private String imgSrc;

    @JsonProperty("earth_date")
    private Date earthDate;

    private Rover rover;

    @Override
    public String toString() {
        return "MarsPhotos{" +
                "id=" + id +
                ", sol=" + sol +
                ", camera=" + camera +
                ", imgSrc='" + imgSrc + '\'' +
                ", earthDate=" + earthDate +
                ", rover=" + rover +
                '}';
    }
}
