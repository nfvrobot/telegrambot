package com.chernyavsky.telegram.converter;

import com.chernyavsky.telegram.dto.CityDto;
import com.chernyavsky.telegram.dbo.CityDbo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CityConverter implements DtoDboConverter<CityDto, CityDbo> {

    @Override
    public CityDto convertToDto(final CityDbo dbo) {
        final CityDto cityDto = new CityDto();
        BeanUtils.copyProperties(dbo, cityDto);
        return cityDto;
    }

    @Override
    public CityDbo convertToDbo(final CityDto dto) {
        final CityDbo cityDbo = new CityDbo();
        BeanUtils.copyProperties(dto, cityDbo);
        return cityDbo;
    }
}
