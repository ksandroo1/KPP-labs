package com.epam.labs.dto;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class YearDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private boolean isLeapYear;

    public YearDto(int year, boolean isLeapYear) {
        this.year = year;
        this.isLeapYear = isLeapYear;
    }
}
