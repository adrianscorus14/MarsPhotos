package com.adrian.demo.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Rover {

    private Long id;
    private String name;

    @JsonProperty("landing_date")
    private Date landingDate;

    @JsonProperty("launch_date")
    private Date launchDate;

    private String status;


    @Override
    public String toString() {
        return "Rover{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", landingDate=" + landingDate +
                ", launchDate=" + launchDate +
                ", status='" + status + '\'' +
                '}';
    }
}
