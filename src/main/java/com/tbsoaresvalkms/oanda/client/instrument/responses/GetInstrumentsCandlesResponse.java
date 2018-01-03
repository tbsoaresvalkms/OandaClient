package com.tbsoaresvalkms.oanda.client.instrument.responses;

import com.tbsoaresvalkms.oanda.client.instrument.models.Candlestick;
import com.tbsoaresvalkms.oanda.client.instrument.models.CandlestickGranularity;
import lombok.Getter;

import java.util.List;

@Getter
public class GetInstrumentsCandlesResponse {
    private List<Candlestick> candles;
    private CandlestickGranularity granularity;
    private String instrument;
}
