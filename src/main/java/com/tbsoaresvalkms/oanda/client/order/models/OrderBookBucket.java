package com.tbsoaresvalkms.oanda.client.order.models;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderBookBucket {
    private BigDecimal price;
    private BigDecimal longCountPercent;
    private BigDecimal shortCountPercent;
}
