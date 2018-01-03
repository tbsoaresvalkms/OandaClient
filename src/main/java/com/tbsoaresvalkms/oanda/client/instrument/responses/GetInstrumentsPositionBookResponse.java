package com.tbsoaresvalkms.oanda.client.instrument.responses;

import com.tbsoaresvalkms.oanda.client.order.models.OrderBook;
import com.tbsoaresvalkms.oanda.client.position.models.PositionBook;
import lombok.Getter;

@Getter
public class GetInstrumentsPositionBookResponse {
    private PositionBook positionBook;
}
