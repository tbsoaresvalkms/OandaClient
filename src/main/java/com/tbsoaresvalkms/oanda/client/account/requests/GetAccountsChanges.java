package com.tbsoaresvalkms.oanda.client.account.requests;

import com.tbsoaresvalkms.oanda.client.account.responses.GetAccountsChangesResponse;
import com.tbsoaresvalkms.oanda.client.core.template.OandaTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetAccountsChanges {

    private final String URL = "/v3/accounts/";
    private OandaTemplate template;

    public GetAccountsChanges(OandaTemplate template) {
        this.template = template;
    }

    public GetAccountsChangesResponse execute(String accountId, String sinceTransactionID) {
        return template.get(builderUrlWithParameter(accountId, sinceTransactionID), GetAccountsChangesResponse.class).getBody();
    }

    private String builderUrlWithParameter(String accountId, String sinceTransactionID) {
        return URL.concat(accountId).concat("/changes").concat("?sinceTransactionID=").concat(sinceTransactionID);
    }
}
