package com.tbsoaresvalkms.oanda.client.instrument.requests;

import com.tbsoaresvalkms.oanda.client.core.template.OandaTemplate;
import com.tbsoaresvalkms.oanda.client.instrument.queries.OrderBookQuery;
import com.tbsoaresvalkms.oanda.client.instrument.responses.GetInstrumentsOrderBookResponse;
import org.springframework.stereotype.Component;

@Component
public class GetInstrumentsOrderBook {

    private final String URL = "/v3/instruments/";
    private final OandaTemplate template;

    public GetInstrumentsOrderBook(OandaTemplate template) {
        this.template = template;
    }

    public GetInstrumentsOrderBookResponse execute(String instrument) {
        return template.get(builderUrl(instrument), GetInstrumentsOrderBookResponse.class).getBody();
    }

    public GetInstrumentsOrderBookResponse execute(String instrument, OrderBookQuery orderBookQuery) {
        return template.get(builderUrl(instrument), orderBookQuery,  GetInstrumentsOrderBookResponse.class).getBody();
    }

    private String builderUrl(String instrument) {
        return URL.concat(instrument).concat("/orderBook");
    }

}
