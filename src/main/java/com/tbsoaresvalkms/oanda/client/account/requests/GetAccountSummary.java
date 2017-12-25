package com.tbsoaresvalkms.oanda.client.account.requests;

import com.tbsoaresvalkms.oanda.client.account.responses.GetAccountSummaryResponse;
import com.tbsoaresvalkms.oanda.client.core.template.OandaTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetAccountSummary {

    private final String URL = "/v3/accounts/";
    private OandaTemplate template;

    public GetAccountSummary(OandaTemplate template) {
        this.template = template;
    }

    public GetAccountSummaryResponse execute(String accountId) {
        return template.get(builderUrl(accountId), GetAccountSummaryResponse.class).getBody();
    }

    private String builderUrl(String accountId) {
        return URL.concat(accountId).concat("/summary");
    }
}
