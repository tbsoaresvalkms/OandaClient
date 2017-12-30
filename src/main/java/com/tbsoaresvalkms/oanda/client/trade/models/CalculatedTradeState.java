package com.tbsoaresvalkms.oanda.client.trade.models;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CalculatedTradeState {
    private String id;
    private BigDecimal unrealizedPL;
}
