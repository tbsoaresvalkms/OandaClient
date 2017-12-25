package com.tbsoaresvalkms.oanda.client.trade.models;

import com.tbsoaresvalkms.oanda.client.transaction.models.ClientExtensions;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class TradeSummary {
    private String id;
    private String instrument;
    private BigDecimal price;
    private LocalDateTime openTime;
    private TradeState state;
    private Double initialUnits;
    private Double currentUnits;
    private BigDecimal realizedPL;
    private BigDecimal unrealizedPL;
    private BigDecimal averageClosePrice;
    private List<String> closingTransactionIDs;
    private BigDecimal financing;
    private LocalDateTime closeTime;
    private ClientExtensions clientExtensions;
    private String takeProfitOrderID;
    private String stopLossOrderID;
    private String trailingStopLossOrderID;
}
