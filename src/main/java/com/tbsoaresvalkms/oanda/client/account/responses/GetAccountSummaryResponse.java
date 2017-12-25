package com.tbsoaresvalkms.oanda.client.account.responses;

import com.tbsoaresvalkms.oanda.client.account.models.Account;
import com.tbsoaresvalkms.oanda.client.account.models.AccountSummary;
import lombok.Getter;

@Getter
public class GetAccountSummaryResponse {
    private AccountSummary account;
    private String lastTransactionID;
}
