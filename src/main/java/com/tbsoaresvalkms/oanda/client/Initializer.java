package com.tbsoaresvalkms.oanda.client;

import com.tbsoaresvalkms.oanda.client.account.models.AccountProperties;
import com.tbsoaresvalkms.oanda.client.account.requests.GetAccount;
import com.tbsoaresvalkms.oanda.client.account.requests.GetAccountSummary;
import com.tbsoaresvalkms.oanda.client.account.requests.GetAccounts;
import com.tbsoaresvalkms.oanda.client.account.requests.GetAccountsInstruments;
import com.tbsoaresvalkms.oanda.client.account.responses.GetAccountsInstrumentsResponse;
import com.tbsoaresvalkms.oanda.client.core.configuration.OandaConfiguration;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Initializer implements ApplicationRunner {
    private OandaConfiguration oandaConfiguration;
    private GetAccounts getAccounts;
    private GetAccount getAccount;
    private GetAccountSummary getAccountSummary;
    private GetAccountsInstruments getAccountsInstruments;

    public Initializer(OandaConfiguration oandaConfiguration, GetAccounts getAccounts, GetAccount getAccount, GetAccountSummary getAccountSummary, GetAccountsInstruments getAccountsInstruments) {
        this.oandaConfiguration = oandaConfiguration;
        this.getAccounts = getAccounts;
        this.getAccount = getAccount;
        this.getAccountSummary = getAccountSummary;
        this.getAccountsInstruments = getAccountsInstruments;
    }


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println(oandaConfiguration.getToken());
        System.out.println(oandaConfiguration.getUrl());
        List<AccountProperties> accounts = getAccounts.execute().getAccounts();

        accounts.forEach(this::getAccount);
    }

    private void getAccount(AccountProperties accountProperties) {
        try {
            Thread.sleep(1000);
            getAccountsInstruments.execute(accountProperties.getId())
                    .getInstruments()
                    .forEach(c -> System.out.println(c.getName()));

            Thread.sleep(1000);
            String alias = getAccount.execute(accountProperties.getId())
                    .getAccount()
                    .getAlias();
            System.out.println(alias);

            Thread.sleep(1000);
            BigDecimal balance = getAccountSummary.execute(accountProperties.getId())
                    .getAccount()
                    .getBalance();
            System.out.println(balance);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
