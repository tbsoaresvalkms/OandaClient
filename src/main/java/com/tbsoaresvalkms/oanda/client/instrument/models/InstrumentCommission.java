package com.tbsoaresvalkms.oanda.client.instrument.models;

import lombok.Getter;

@Getter
public class InstrumentCommission {
    private String instrument;
    private Double commission;
    private Double unitsTraded;
    private Double minimumCommission;
}
