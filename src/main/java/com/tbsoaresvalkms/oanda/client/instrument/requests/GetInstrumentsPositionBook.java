package com.tbsoaresvalkms.oanda.client.instrument.requests;

import com.tbsoaresvalkms.oanda.client.core.template.OandaTemplate;
import com.tbsoaresvalkms.oanda.client.instrument.queries.OrderBookQuery;
import com.tbsoaresvalkms.oanda.client.instrument.queries.PositionBookQuery;
import com.tbsoaresvalkms.oanda.client.instrument.responses.GetInstrumentsOrderBookResponse;
import com.tbsoaresvalkms.oanda.client.instrument.responses.GetInstrumentsPositionBookResponse;
import com.tbsoaresvalkms.oanda.client.position.models.PositionBook;
import org.springframework.stereotype.Component;

@Component
public class GetInstrumentsPositionBook {

    private final String URL = "/v3/instruments/";
    private final OandaTemplate template;

    public GetInstrumentsPositionBook(OandaTemplate template) {
        this.template = template;
    }

    public GetInstrumentsPositionBookResponse execute(String instrument) {
        return template.get(builderUrl(instrument), GetInstrumentsPositionBookResponse.class).getBody();
    }

    public GetInstrumentsPositionBookResponse execute(String instrument, PositionBookQuery positionBookQuery) {
        return template.get(builderUrl(instrument), positionBookQuery, GetInstrumentsPositionBookResponse.class).getBody();
    }

    private String builderUrl(String instrument) {
        return URL.concat(instrument).concat("/positionBook");
    }
}
