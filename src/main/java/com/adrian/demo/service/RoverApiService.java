package com.adrian.demo.service;


import com.adrian.demo.dto.HomeDto;
import com.adrian.demo.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class RoverApiService {

    private final static String API_KEY="CTuxJjeOnmQyzKCy8KVMqD2Rza6qJJiVKQ6bhFqy";





    public ApiResponse getHomeRoverData(String apiRoverData){



        String url="https://api.nasa.gov/mars-photos/api/v1/rovers/"+apiRoverData+"/photos?sol=2&api_key="+API_KEY;

        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<ApiResponse> response=restTemplate.getForEntity(url,ApiResponse.class);

        return response.getBody();
    }

    public ApiResponse getAdvancedSearchData(String apiRoverData,Integer marsSol){
        String url="https://api.nasa.gov/mars-photos/api/v1/rovers/"+apiRoverData+"/photos?sol="+marsSol+"&api_key="+API_KEY;

        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<ApiResponse> response=restTemplate.getForEntity(url,ApiResponse.class);

        return response.getBody();

    }





}
