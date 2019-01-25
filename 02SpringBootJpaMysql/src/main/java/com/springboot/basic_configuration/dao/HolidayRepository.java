package com.springboot.basic_configuration.dao;

import com.springboot.basic_configuration.entity.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, Long> {

    @Query(value = "SELECT p FROM HolidayEntity p")
    List<HolidayEntity> queryHoliday();

}
