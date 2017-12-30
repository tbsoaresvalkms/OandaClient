package com.tbsoaresvalkms.oanda.client.transaction.models;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Transaction {
    private String id;
    private LocalDateTime time;
    private Integer userID;
    private String accountID;
    private String batchID;
    private String requestID;
}
