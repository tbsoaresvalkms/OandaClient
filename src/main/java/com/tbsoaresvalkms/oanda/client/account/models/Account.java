package com.tbsoaresvalkms.oanda.client.account.models;

import com.tbsoaresvalkms.oanda.client.instrument.models.Currency;
import com.tbsoaresvalkms.oanda.client.order.models.Order;
import com.tbsoaresvalkms.oanda.client.position.models.Position;
import com.tbsoaresvalkms.oanda.client.trade.models.TradeSummary;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Account {
    private String id;
    private String alias;
    private Currency currency;
    private BigDecimal balance;
    private String createdByUserID;
    private LocalDateTime createdTime;
    private BigDecimal pl;
    private BigDecimal resettablePL;
    private LocalDateTime resettabledPLTime;
    private BigDecimal commission;
    private BigDecimal marginRate;
    private LocalDateTime marginCallEnterTime;
    private Integer marginCallExtensionCount;
    private LocalDateTime lastMarginCallExtensionTime;
    private Integer openTradeCount;
    private Integer openPositionCount;
    private Integer pendingOrderCount;
    private Boolean hedgingEnabled;
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
    private BigDecimal marginCallMarginUsed;
    private BigDecimal marginCallPercent;
    private String lastTransactionID;
    private List<TradeSummary> trades;
    private List<Position> positions;
    private List<Order> orders;
}
