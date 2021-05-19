package com.epam.labs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MyYear {
    @JsonProperty(value = "year")
    @Min(1)
    private int currentYear;
}
