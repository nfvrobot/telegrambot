package com.chernyavsky.telegram.controller;

import com.chernyavsky.telegram.dto.CityDto;
import com.chernyavsky.telegram.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/create")
    public String createCity(@RequestBody CityDto cityDto) {
        cityService.createCity(cityDto);
        return "City created";
    }

    @GetMapping("/list")
    public List<CityDto> getListOfCity() {
        return cityService.getAllCity();
    }

    @GetMapping("/city/{id}")
    public CityDto getCity(@PathVariable Long id) {
        return cityService.getCity(id);
    }
}
