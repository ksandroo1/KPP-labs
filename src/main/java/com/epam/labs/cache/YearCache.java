package com.epam.labs.cache;

import com.epam.labs.dto.MyYear;
import com.epam.labs.dto.YearDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class YearCache {
    private Map<MyYear, YearDto> map = new HashMap<>();

    public boolean isAlreadyHashed(MyYear year) {
        return map.containsKey(year);
    }

    public void addToMap(MyYear myYear, YearDto yearDto) {
        map.put(myYear, yearDto);
    }

    public YearDto getYearDto(MyYear year){
        return map.get(year);
    }

    public Map<MyYear, YearDto> getCache(){
        return new HashMap<>(map);
    }
}
