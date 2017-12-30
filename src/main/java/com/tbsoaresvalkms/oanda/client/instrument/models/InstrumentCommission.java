package com.tbsoaresvalkms.oanda.client.instrument.models;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class InstrumentCommission {
    private String instrument;
    private BigDecimal commission;
    private BigDecimal unitsTraded;
    private BigDecimal minimumCommission;
}
