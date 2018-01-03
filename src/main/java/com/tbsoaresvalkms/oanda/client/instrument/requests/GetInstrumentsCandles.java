package com.tbsoaresvalkms.oanda.client.instrument.requests;

import com.tbsoaresvalkms.oanda.client.core.template.OandaTemplate;
import com.tbsoaresvalkms.oanda.client.instrument.queries.InstrumentCandlesQuery;
import com.tbsoaresvalkms.oanda.client.instrument.responses.GetInstrumentsCandlesResponse;
import org.springframework.stereotype.Component;

@Component
public class GetInstrumentsCandles {

    private final String URL = "/v3/instruments/";
    private final OandaTemplate template;

    public GetInstrumentsCandles(OandaTemplate template) {
        this.template = template;
    }

    public GetInstrumentsCandlesResponse execute(String instrument) {
        return template.get(builderUrl(instrument), GetInstrumentsCandlesResponse.class).getBody();
    }

    public GetInstrumentsCandlesResponse execute(String instrument, InstrumentCandlesQuery instrumentCandles) {
        return template.get(builderUrl(instrument), instrumentCandles, GetInstrumentsCandlesResponse.class).getBody();
    }

    private String builderUrl(String instrument) {
        return URL.concat(instrument).concat("/candles");
    }

}
