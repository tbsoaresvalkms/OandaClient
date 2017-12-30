package com.tbsoaresvalkms.oanda.client.account.responses;

import com.tbsoaresvalkms.oanda.client.account.models.AccountChanges;
import com.tbsoaresvalkms.oanda.client.account.models.AccountChangesState;
import lombok.Getter;

@Getter
public class GetAccountsChangesResponse {
    private AccountChanges changes;
    private AccountChangesState state;
    private String lastTransactionID;
}
