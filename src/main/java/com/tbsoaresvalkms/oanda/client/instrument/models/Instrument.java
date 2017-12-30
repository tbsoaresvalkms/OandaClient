package com.tbsoaresvalkms.oanda.client.instrument.models;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Instrument {
    private String name;
    private InstrumentType type;
    private String displayName;
    private Integer pipLocation;
    private Integer displayPrecision;
    private Integer tradeUnitsPrecision;
    private BigDecimal minimumTradeSize;
    private BigDecimal maximumTrailingStopDistance;
    private BigDecimal minimumTrailingStopDistance;
    private BigDecimal maximumPositionSize;
    private BigDecimal maximumOrderUnits;
    private BigDecimal marginRate;
    private InstrumentCommission commission;
}
