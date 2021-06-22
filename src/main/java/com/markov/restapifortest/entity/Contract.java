package com.markov.restapifortest.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Contract {
    private int id;
    private String description;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate date;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateOfLastUpdate;
}
