package com.tbsoaresvalkms.oanda.client.order.models;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderBook {
    private String instrument;
    private LocalDateTime time;
    private BigDecimal price;
    private BigDecimal bucketWidth;
    private List<OrderBookBucket> buckets;
}
