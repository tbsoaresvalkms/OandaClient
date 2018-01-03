package com.tbsoaresvalkms.oanda.client.position.models;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PositionBook {
    private String instrumentName;
    private LocalDateTime time;
    private BigDecimal price;
    private BigDecimal bucketWidth;
    private List<PositionBookBucket> buckets;
}
