package com.tbsoaresvalkms.oanda.client.account.requests;

import com.tbsoaresvalkms.oanda.client.account.responses.GetAccountsInstrumentsResponse;
import com.tbsoaresvalkms.oanda.client.core.template.OandaTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetAccountsInstruments {

    private final String URL = "/v3/accounts/";
    private OandaTemplate template;

    public GetAccountsInstruments(OandaTemplate template) {
        this.template = template;
    }

    public GetAccountsInstrumentsResponse execute(String accountId) {
        return template.get(builderUrl(accountId), GetAccountsInstrumentsResponse.class).getBody();
    }

    public GetAccountsInstrumentsResponse execute(String accountId, String instrumentName) {
        return template.get(builderUrlWithParameter(accountId, instrumentName), GetAccountsInstrumentsResponse.class).getBody();
    }

    private String builderUrl(String accountId) {
        return URL.concat(accountId).concat("/instruments");
    }

    private String builderUrlWithParameter(String accountId, String instrumentName) {
        return URL.concat(accountId).concat("/instruments").concat("?instruments=").concat(instrumentName);
    }
}
