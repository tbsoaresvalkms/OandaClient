package com.tbsoaresvalkms.oanda.client.order.models;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class DynamicOrderState {
    private String id;
    private BigDecimal trailingStopValue;
    private BigDecimal triggerDistance;
    private Boolean isTriggerDistanceExact;
}
