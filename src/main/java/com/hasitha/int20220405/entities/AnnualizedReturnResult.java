package com.hasitha.int20220405.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnnualizedReturnResult {
    private String symbol;
    private int duration;
    private double annualizedReturn;
}
