package com.tbsoaresvalkms.oanda.client.instrument.responses;

import com.tbsoaresvalkms.oanda.client.order.models.OrderBook;
import lombok.Getter;

@Getter
public class GetInstrumentsOrderBookResponse {
    private OrderBook orderBook;
}
