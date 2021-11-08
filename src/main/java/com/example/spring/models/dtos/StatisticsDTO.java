package com.example.spring.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class StatisticsDTO {

    private long id;
    private int vowelsNumber;
    private int consonantsNumber;
    private String vowels;
    private String consonants;
    private String line;
    private String typeInput;
    private Timestamp timestamp;
}
