package com.epam.labs.service;

import com.epam.labs.cache.YearCache;
import com.epam.labs.calculator.Calculator;
import com.epam.labs.dto.MyYear;
import com.epam.labs.dto.YearDto;
import com.epam.labs.dto.YearsList;
import com.epam.labs.logger.Logger;
import com.epam.labs.repository.YearDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class YearService {
    @Autowired
    private YearCache cache;
    @Autowired
    private CounterService counterService;
    @Autowired
    private Logger logger;
    @Autowired
    private Calculator calculator;

    public YearsList createYearsDto(List<MyYear> years) {
        logCounter();
        List<YearDto> yearsDto = new ArrayList<>();
        years.stream().filter(cache::isAlreadyHashed).forEach((year) -> {
            yearsDto.add(cache.getYearDto(year));
        });
        years.stream().filter((myYear -> !cache.isAlreadyHashed(myYear))).forEach(myYear -> {
            YearDto dto = new YearDto(myYear.getCurrentYear(), isLeapYear(myYear.getCurrentYear()));
            cache.addToMap(myYear, dto);
            yearsDto.add(dto);
        });
        return new YearsList(yearsDto,calculator.calculateMaxYear(),
                calculator.calculateMinYear(),calculator.calculateOverageYear());
    }

    private boolean isLeapYear(int year) {
        boolean result = false;
        if (year % 4 == 0) {
            if ((year % 100 != 0) || (year % 400 == 0)) {
                result = true;
            }
        }
        return result;
    }

    private void logCounter() {
        int count = counterService.incrementAndGetCounter();
        logger.doLog("Number of counts = " + count);
    }
}
