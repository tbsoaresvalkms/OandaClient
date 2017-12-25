package com.tbsoaresvalkms.oanda.client.instrument.models;

import lombok.Getter;

@Getter
public class Instrument {
    private String name;
    private InstrumentType type;
    private String displayName;
    private Integer pipLocation;
    private Integer displayPrecision;
    private Integer tradeUnitsPrecision;
    private Double minimumTradeSize;
    private Double maximumTrailingStopDistance;
    private Double minimumTrailingStopDistance;
    private Double maximumPositionSize;
    private Double maximumOrderUnits;
    private Double marginRate;
    private InstrumentCommission commission;
}
