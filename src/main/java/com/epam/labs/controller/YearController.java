package com.epam.labs.controller;

import com.epam.labs.dto.MyYear;
import com.epam.labs.dto.YearDto;
import com.epam.labs.dto.YearsList;
import com.epam.labs.logger.Logger;
import com.epam.labs.repository.YearDtoRepository;
import com.epam.labs.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/years")
public class YearController {
    @Autowired
    private YearService service;
    @Autowired
    private Logger logger;
    @Autowired
    private YearDtoRepository repository;

    @GetMapping("/checkYears")
    public ResponseEntity checkIsLeapYear(@Valid @RequestBody MyYear year) {
       return doController(Arrays.asList(year));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        List<YearDto> dtos = (List<YearDto>) repository.findAll();
        return ResponseEntity.ok(dtos);
        график плотности случайной величины я изобразил если оценка не смещенная то бла бла бла
    }

    @PostMapping("/checkYears")
    public ResponseEntity checkIsLeapYears(@Valid @RequestBody List<MyYear> years) {
        return doController(years);
    }
    private ResponseEntity doController(List<MyYear> years){
        logger.doLog("Get parameter : " + years);
        YearsList yearsList = service.createYearsDto(years);
        logger.doLog("Return parameter : " + yearsList);
        yearsList.getYearDtoList().forEach(repository::save);
        return ResponseEntity.ok(yearsList);
    }
}
