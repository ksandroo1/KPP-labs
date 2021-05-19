package com.epam.labs.service;

import com.epam.labs.cache.YearCache;
import com.epam.labs.calculator.Calculator;
import com.epam.labs.dto.MyYear;
import com.epam.labs.dto.YearDto;
import com.epam.labs.dto.YearsList;
import com.epam.labs.logger.Logger;
import com.epam.labs.repository.YearDtoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {YearService.class, YearCache.class,CounterService.class, Logger.class, Calculator.class},
        loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class YearServiceTest {
    @Autowired
    private YearService service;

    @Test
    public void testCreateYearsDto_true() {
        MyYear year = new MyYear(2020);
        YearsList actual = service.createYearsDto(Arrays.asList(year));
        YearsList expected =new YearsList(Arrays.asList(new YearDto(2020,true)),0,0,0);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testCreateYearsDto_false() {
        MyYear year = new MyYear(2019);
        YearsList actual = service.createYearsDto(Arrays.asList(year));
        YearsList expected = new YearsList(Arrays.asList(new YearDto(2019,false)),0,0,0);
        Assertions.assertEquals(expected,actual);
    }
}
