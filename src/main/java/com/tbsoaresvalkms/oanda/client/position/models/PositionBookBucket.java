package com.tbsoaresvalkms.oanda.client.position.models;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PositionBookBucket {
    private BigDecimal price;
    private BigDecimal longCountPercent;
    private BigDecimal shortCountPercent;
}
