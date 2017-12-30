package com.tbsoaresvalkms.oanda.client.account.models;

import com.tbsoaresvalkms.oanda.client.order.models.DynamicOrderState;
import com.tbsoaresvalkms.oanda.client.position.models.CalculatedPositionSate;
import com.tbsoaresvalkms.oanda.client.trade.models.CalculatedTradeState;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class AccountChangesState {
    private BigDecimal unrealizedPL;
    private BigDecimal NAV;
    private BigDecimal marginUsed;
    private BigDecimal marginAvailable;
    private BigDecimal positionValue;
    private BigDecimal marginCloseoutUnrealizedPL;
    private BigDecimal marginCloseoutNAV;
    private BigDecimal marginCloseoutMarginUsed;
    private BigDecimal marginCloseoutPercent;
    private BigDecimal marginCloseoutPositionValue;
    private BigDecimal withdrawalLimit;
    private BigDecimal marginCallPercent;
    private List<DynamicOrderState> orders;
    private List<CalculatedTradeState> trades;
    private List<CalculatedPositionSate> positions;
}
