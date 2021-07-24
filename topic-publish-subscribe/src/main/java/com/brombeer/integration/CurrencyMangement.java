package com.brombeer.integration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyMangement implements Serializable {

    private String miNumber;
    private String personalNumber;
    private String capsReference;
    private LocalDateTime assignDate;
    private LocalDateTime expiryDate;
    private String capsStatus;



}
