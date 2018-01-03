package com.tbsoaresvalkms.oanda.client.instrument.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CandlestickData {
    @JsonProperty("o")
    private BigDecimal open;
    @JsonProperty("h")
    private BigDecimal high;
    @JsonProperty("l")
    private BigDecimal low;
    @JsonProperty("c")
    private BigDecimal close;
}
