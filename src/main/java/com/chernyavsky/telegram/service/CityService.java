package com.chernyavsky.telegram.service;

import com.chernyavsky.telegram.converter.CityConverter;
import com.chernyavsky.telegram.dto.CityDto;
import com.chernyavsky.telegram.repository.JpaCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final JpaCityRepository jpaCityRepository;
    private final CityConverter cityConverter;

    @Autowired
    public CityService(final JpaCityRepository jpaCityRepository, final CityConverter cityConverter) {
        this.jpaCityRepository = jpaCityRepository;
        this.cityConverter = cityConverter;
    }

    public CityDto getCity(Long id) {
        return cityConverter.convertToDto(jpaCityRepository.getCityDboById(id));
    }

    public void createCity(CityDto cityDto) {
        jpaCityRepository.save(cityConverter.convertToDbo(cityDto));
    }

    public List<CityDto> getAllCity() {
        return jpaCityRepository.findAll().stream()
                .map(cityConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public CityDto getCityByName(String name) {
        return cityConverter.convertToDto(jpaCityRepository.getCityByName(name));
    }
}
