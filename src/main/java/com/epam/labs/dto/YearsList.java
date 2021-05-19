package com.epam.labs.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"maxYear","minYear","average"})
@ToString
public class YearsList {
    @NonNull
    private List<YearDto> yearDtoList;
    private int maxYear;
    private int minYear;
    private double average;
}
