package com.tbsoaresvalkms.oanda.client.account.responses;

import com.tbsoaresvalkms.oanda.client.transaction.models.ClientConfigureTransaction;
import lombok.Getter;

@Getter
public class PatchAccountsConfigurationResponse {
    private ClientConfigureTransaction clientConfigureTransaction;
    private String lastTransactionID;
}
