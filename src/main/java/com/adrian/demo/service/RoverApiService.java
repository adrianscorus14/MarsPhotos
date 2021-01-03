package com.adrian.demo.service;


import com.adrian.demo.dto.HomeDto;
import com.adrian.demo.response.ApiResponse;
import com.adrian.demo.response.MarsPhotos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoverApiService {

    private final static String API_KEY="CTuxJjeOnmQyzKCy8KVMqD2Rza6qJJiVKQ6bhFqy";





    public ApiResponse getHomeRoverData(String apiRoverData){



        String url="https://api.nasa.gov/mars-photos/api/v1/rovers/"+apiRoverData+"/photos?sol=2&api_key="+API_KEY;

        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<ApiResponse> response=restTemplate.getForEntity(url,ApiResponse.class);

        return response.getBody();
    }

    public ApiResponse getAdvancedSearchData(HomeDto homeDto){

        RestTemplate restTemplate=new RestTemplate();
        List<String> apiUrlEndPoints=getUrlEndPoints(homeDto);
        List<MarsPhotos> photos=new ArrayList<>();
        ApiResponse response=new ApiResponse();
        apiUrlEndPoints.stream().forEach(url ->{
            ApiResponse apiResponse=restTemplate.getForObject(url,ApiResponse.class);
            photos.addAll(apiResponse.getPhotos());
        });
        response.setPhotos(photos);

        return response;

    }

    public List<String> getUrlEndPoints(HomeDto homeDto){

        List<String> urls=new ArrayList<>();
        if(Boolean.TRUE.equals(homeDto.getCameraFhaz())){
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera=FHAZ");
        }
        if(Boolean.TRUE.equals(homeDto.getCameraRhaz())){
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera=RHAZ");
        }
        if(Boolean.TRUE.equals(homeDto.getCameraMast()) &&"curiosity".equalsIgnoreCase(homeDto.getApiRoverData())){
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera=MAST");
        }
        if(Boolean.TRUE.equals(homeDto.getCameraChemcam()) &&"curiosity".equalsIgnoreCase(homeDto.getApiRoverData())){
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera=CHEMCAM");
        }
        if(Boolean.TRUE.equals(homeDto.getCameraMahli()) &&"curiosity".equalsIgnoreCase(homeDto.getApiRoverData())){
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera=MAHLI");
        }
        if(Boolean.TRUE.equals(homeDto.getCameraMardi()) &&"curiosity".equalsIgnoreCase(homeDto.getApiRoverData())){
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera=MARDI");
        }
        if(Boolean.TRUE.equals(homeDto.getCameraNavcam())){
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera=NAVCAM");
        }
        if(Boolean.TRUE.equals(homeDto.getCameraPancam()) && !"curiosity".equalsIgnoreCase(homeDto.getApiRoverData())){
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera=PANCAM");
        }
        if(Boolean.TRUE.equals(homeDto.getCameraMinites()) && !"curiosity".equalsIgnoreCase(homeDto.getApiRoverData())){
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getApiRoverData()+"/photos?sol="+homeDto.getMarsSol()+"&api_key="+API_KEY+"&camera=MINITES");
        }

        return urls;

    }





}
