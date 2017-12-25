package com.tbsoaresvalkms.oanda.client.order.models;

import com.tbsoaresvalkms.oanda.client.transaction.models.ClientExtensions;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.PrimitiveIterator;

@Getter
public class Order {
    private String id;
    private LocalDateTime createTime;
    private OrderState state;
    private ClientExtensions clientExtensions;
}
