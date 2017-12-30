package com.tbsoaresvalkms.oanda.client.transaction.models;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class ClientConfigureTransaction {
    private String id;
    private LocalDateTime time;
    private Integer userID;
    private String accountID;
    private String batchID;
    private String requestID;
    private TransactionType type;
    private String alias;
    private BigDecimal marginRate;
}
