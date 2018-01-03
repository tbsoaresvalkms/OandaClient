package com.tbsoaresvalkms.oanda.client.account.requests;

import com.tbsoaresvalkms.oanda.client.account.queries.AccountConfigurationBody;
import com.tbsoaresvalkms.oanda.client.account.responses.PatchAccountsConfigurationResponse;
import com.tbsoaresvalkms.oanda.client.core.template.OandaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PatchAccountsConfiguration {

    private final String URL = "/v3/accounts/";
    private final OandaTemplate template;

    public PatchAccountsConfiguration(OandaTemplate template) {
        this.template = template;
    }

    public PatchAccountsConfigurationResponse execute(String accountId, AccountConfigurationBody accountConfiguration) {
        return template.patch(builderUrl(accountId), accountConfiguration, PatchAccountsConfigurationResponse.class).getBody();
    }

    private String builderUrl(String accountId) {
        return URL.concat(accountId).concat("/configuration");
    }
}
