package com.tbsoaresvalkms.oanda.client.account.models;

import com.tbsoaresvalkms.oanda.client.order.models.Order;
import com.tbsoaresvalkms.oanda.client.position.models.Position;
import com.tbsoaresvalkms.oanda.client.trade.models.TradeSummary;
import com.tbsoaresvalkms.oanda.client.transaction.models.Transaction;
import lombok.Getter;

import java.util.List;

@Getter
public class AccountChanges {
    private List<Order> ordersCreated;
    private List<Order> ordersCancelled;
    private List<Order> ordersFilled;
    private List<Order> ordersTriggered;
    private List<TradeSummary> tradesOpened;
    private List<TradeSummary> tradesReduced;
    private List<TradeSummary> tradesClosed;
    private List<Position> positions;
    private List<Transaction> transactions;
}
