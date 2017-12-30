package com.tbsoaresvalkms.oanda.client;

import com.tbsoaresvalkms.oanda.client.account.queries.AccountConfiguration;
import com.tbsoaresvalkms.oanda.client.account.requests.*;
import com.tbsoaresvalkms.oanda.client.account.responses.GetAccountResponse;
import com.tbsoaresvalkms.oanda.client.core.configuration.OandaConfiguration;
import com.tbsoaresvalkms.oanda.client.core.convert.BigDecimalToJsonConvert;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Initializer implements ApplicationRunner {
    private OandaConfiguration oandaConfiguration;
    private GetAccounts getAccounts;
    private GetAccount getAccount;
    private GetAccountSummary getAccountSummary;
    private GetAccountsInstruments getAccountsInstruments;
    private GetAccountsChanges getAccountsChanges;
    private PatchAccountsConfiguration patchAccountsConfiguration;

    public Initializer(OandaConfiguration oandaConfiguration, GetAccounts getAccounts, GetAccount getAccount, GetAccountSummary getAccountSummary, GetAccountsInstruments getAccountsInstruments, GetAccountsChanges getAccountsChanges, PatchAccountsConfiguration patchAccountsConfiguration) {
        this.oandaConfiguration = oandaConfiguration;
        this.getAccounts = getAccounts;
        this.getAccount = getAccount;
        this.getAccountSummary = getAccountSummary;
        this.getAccountsInstruments = getAccountsInstruments;
        this.getAccountsChanges = getAccountsChanges;
        this.patchAccountsConfiguration = patchAccountsConfiguration;
    }


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        getAccounts.execute()
                .getAccounts()
                .stream()
                .findFirst()
                .map(i -> getAccount.execute(i.getId()))
                .map(GetAccountResponse::getAccount)
                .map(account -> {
                    System.out.println(account.getAlias());
                    return patchAccountsConfiguration.execute(
                            account.getId(),
                            AccountConfiguration.builder()
                                    .marginRate(BigDecimal.valueOf(0.001))
                                    .build());
                })
                .ifPresent(c -> System.out.println(c.getClientConfigureTransaction().getAlias()));
    }

}
