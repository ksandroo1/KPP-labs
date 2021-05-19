package com.epam.labs.calculator;

import com.epam.labs.cache.YearCache;
import com.epam.labs.dto.MyYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class Calculator {
    @Autowired
    private YearCache cache;

    private Set<MyYear> getYears() {
        return cache.getCache().keySet();
    }

    public int calculateMaxYear() {
        List<MyYear> myYears = new ArrayList<>(getYears());
        return myYears.stream().map(MyYear::getCurrentYear).max(Integer::compare).orElse(0);
    }

    public int calculateMinYear() {
        List<MyYear> myYears = new ArrayList<>(getYears());
        return myYears.stream().map(MyYear::getCurrentYear).min(Integer::compare).orElse(0);
    }

    public double calculateOverageYear() {
        List<MyYear> myYears = new ArrayList<>(getYears());
        return myYears.stream().mapToInt(MyYear::getCurrentYear).average().orElse(0);
    }
}
