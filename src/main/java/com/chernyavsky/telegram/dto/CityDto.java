package com.chernyavsky.telegram.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityDto {

    private Long id;
    private String name;
    private String info;
}
