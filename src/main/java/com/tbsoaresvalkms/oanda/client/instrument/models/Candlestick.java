package com.tbsoaresvalkms.oanda.client.instrument.models;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Candlestick {
    private LocalDateTime time;
    private CandlestickData bid;
    private CandlestickData ask;
    private CandlestickData mid;
    private Long volume;
    private Boolean complete;
}
