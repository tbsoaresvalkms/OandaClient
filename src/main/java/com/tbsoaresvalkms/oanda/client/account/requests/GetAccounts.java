package com.tbsoaresvalkms.oanda.client.account.requests;

import com.tbsoaresvalkms.oanda.client.account.responses.GetAccountsResponse;
import com.tbsoaresvalkms.oanda.client.core.template.OandaTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetAccounts {

    private final String URL = "/v3/accounts";
    private OandaTemplate template;

    public GetAccounts(OandaTemplate template) {
        this.template = template;
    }

    public GetAccountsResponse execute() {
        return template.get(URL, GetAccountsResponse.class).getBody();
    }
}
