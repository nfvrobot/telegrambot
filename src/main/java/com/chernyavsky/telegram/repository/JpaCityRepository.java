package com.chernyavsky.telegram.repository;

import com.chernyavsky.telegram.dbo.CityDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface JpaCityRepository extends JpaRepository<CityDbo, Long> {

    CityDbo getCityByName(String name);
    CityDbo getCityDboById(Long id);
}
