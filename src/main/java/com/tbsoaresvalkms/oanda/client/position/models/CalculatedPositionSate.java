package com.tbsoaresvalkms.oanda.client.position.models;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CalculatedPositionSate {
    private String instrument;
    private BigDecimal netUnrealizedPL;
    private BigDecimal longUnrealizedPL;
    private BigDecimal shortUnrealizedPL;
}
