package com.tbsoaresvalkms.oanda.client.position.models;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class PositionSide {
    private BigDecimal units;
    private BigDecimal averagePrice;
    private List<String> tradeIDs;
    private BigDecimal pl;
    private BigDecimal unrealizedPL;
    private BigDecimal resettablePL;
}
