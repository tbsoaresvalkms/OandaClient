package com.tbsoaresvalkms.oanda.client.account.requests;

import com.tbsoaresvalkms.oanda.client.account.responses.GetAccountResponse;
import com.tbsoaresvalkms.oanda.client.core.template.OandaTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetAccount {

    private final String URL = "/v3/accounts/";
    private final OandaTemplate template;

    public GetAccount(OandaTemplate template) {
        this.template = template;
    }

    public GetAccountResponse execute(String accountId) {
        return template.get(builderUrl(accountId), GetAccountResponse.class).getBody();
    }

    private String builderUrl(String accountId) {
        return URL.concat(accountId);
    }
}
