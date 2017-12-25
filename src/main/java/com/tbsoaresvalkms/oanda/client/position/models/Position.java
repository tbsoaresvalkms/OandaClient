package com.tbsoaresvalkms.oanda.client.position.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Position {
    private String instrument;
    private BigDecimal pl;
    private BigDecimal unrealizedPL;
    private BigDecimal resettablePL;
    private BigDecimal commission;
    @JsonProperty("long")
    private PositionSide longValue;
    @JsonProperty("short")
    private PositionSide shortValue;
}
