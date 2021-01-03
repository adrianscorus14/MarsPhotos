package com.adrian.demo.controller;


import com.adrian.demo.dto.HomeDto;
import com.adrian.demo.response.ApiResponse;
import com.adrian.demo.service.RoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
public class HomeController {

    @Autowired
    private RoverApiService roverService;


    @GetMapping("/")
    public String homePage(ModelMap modelMap,@RequestParam(required = false) String apiRoverData){

        if(StringUtils.isEmpty(apiRoverData)){
            apiRoverData="Opportunity";
        }
        ApiResponse roverData= roverService.getHomeRoverData(apiRoverData);
        modelMap.put("roverData",roverData);

        return "index";
    }

    @GetMapping("/advancedsearch")
    public String advancedSearchPage(ModelMap modelMap, HomeDto homeDto)  {
        if(homeDto.getMarsSol()==null){
            homeDto.setMarsSol(1);
        }
        if(StringUtils.isEmpty(homeDto.getApiRoverData())){
            homeDto.setApiRoverData("Opportunity");
        }
        ApiResponse roverData= roverService.getAdvancedSearchData(homeDto);

        modelMap.put("roverData",roverData);
        modelMap.put("homeDto",homeDto);

        return "advancedsearch";
        
    }



}
