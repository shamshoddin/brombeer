package com.brombeer.integration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private String name;
    private String training;
    private int noOfTrainings;
    private LocalDateTime timestamp;



}
