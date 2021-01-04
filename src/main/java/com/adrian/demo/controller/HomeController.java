package com.adrian.demo.controller;


import com.adrian.demo.dto.HomeDto;
import com.adrian.demo.response.ApiResponse;
import com.adrian.demo.service.RoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.lang.reflect.InvocationTargetException;

@Controller
public class HomeController {

    @Autowired
    private RoverApiService roverService;


    @GetMapping("/")
    public String homePage(Model model, @RequestParam(required = false) String apiRoverData){

        if(StringUtils.isEmpty(apiRoverData)){
            apiRoverData="Opportunity";
        }
        ApiResponse roverData= roverService.getHomeRoverData(apiRoverData);
        model.addAttribute("roverData",roverData);

        return "index";
    }

    @GetMapping("/advancedsearch")
    public String advancedSearchPage(Model model, HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        if(homeDto.getMarsSol()==null){
            homeDto.setMarsSol(1);
        }
        if(StringUtils.isEmpty(homeDto.getApiRoverData())){
            homeDto.setApiRoverData("Opportunity");
        }
        ApiResponse roverData= roverService.getAdvancedSearchData(homeDto);

        model.addAttribute("roverData",roverData);
        model.addAttribute("homeDto",homeDto);
        model.addAttribute("validCameras",roverService.getValidCameras().get(homeDto.getApiRoverData()));

        return "advancedsearch";
        
    }

}
