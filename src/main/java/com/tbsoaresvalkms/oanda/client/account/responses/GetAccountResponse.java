package com.tbsoaresvalkms.oanda.client.account.responses;

import com.tbsoaresvalkms.oanda.client.account.models.Account;
import lombok.Getter;

@Getter
public class GetAccountResponse {
    private Account account;
    private String lastTransactionID;
}
