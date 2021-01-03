package com.adrian.demo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class ApiResponse {
    List<MarsPhotos> photos=new ArrayList<>();


    @Override
    public String toString() {
        return "ApiResponse{" +
                "photos=" + photos +
                '}';
    }
}
