package com.tbsoaresvalkms.oanda.client;

import com.tbsoaresvalkms.oanda.client.account.queries.AccountConfigurationBody;
import com.tbsoaresvalkms.oanda.client.account.requests.*;
import com.tbsoaresvalkms.oanda.client.account.responses.GetAccountResponse;
import com.tbsoaresvalkms.oanda.client.core.configuration.OandaConfiguration;
import com.tbsoaresvalkms.oanda.client.instrument.models.CandlestickData;
import com.tbsoaresvalkms.oanda.client.instrument.models.CandlestickGranularity;
import com.tbsoaresvalkms.oanda.client.instrument.models.PriceType;
import com.tbsoaresvalkms.oanda.client.instrument.queries.InstrumentCandlesQuery;
import com.tbsoaresvalkms.oanda.client.instrument.requests.GetInstrumentsCandles;
import com.tbsoaresvalkms.oanda.client.instrument.requests.GetInstrumentsOrderBook;
import com.tbsoaresvalkms.oanda.client.instrument.requests.GetInstrumentsPositionBook;
import com.tbsoaresvalkms.oanda.client.order.models.OrderBookBucket;
import com.tbsoaresvalkms.oanda.client.position.models.PositionBookBucket;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.stream.Stream;

@Component
public class Initializer implements ApplicationRunner {
    private OandaConfiguration oandaConfiguration;
    private GetAccounts getAccounts;
    private GetAccount getAccount;
    private GetAccountSummary getAccountSummary;
    private GetAccountsInstruments getAccountsInstruments;
    private GetAccountsChanges getAccountsChanges;
    private GetInstrumentsCandles getInstrumentsCandles;
    private GetInstrumentsOrderBook getInstrumentsOrderBook;
    private GetInstrumentsPositionBook getInstrumentsPositionBook;
    private PatchAccountsConfiguration patchAccountsConfiguration;

    public Initializer(OandaConfiguration oandaConfiguration, GetAccounts getAccounts, GetAccount getAccount, GetAccountSummary getAccountSummary, GetAccountsInstruments getAccountsInstruments, GetAccountsChanges getAccountsChanges, GetInstrumentsCandles instrumentsCandles, GetInstrumentsOrderBook getInstrumentsOrderBook, GetInstrumentsPositionBook getInstrumentsPositionBook, PatchAccountsConfiguration patchAccountsConfiguration) {
        this.oandaConfiguration = oandaConfiguration;
        this.getAccounts = getAccounts;
        this.getAccount = getAccount;
        this.getAccountSummary = getAccountSummary;
        this.getAccountsInstruments = getAccountsInstruments;
        this.getAccountsChanges = getAccountsChanges;
        this.getInstrumentsCandles = instrumentsCandles;
        this.getInstrumentsOrderBook = getInstrumentsOrderBook;
        this.getInstrumentsPositionBook = getInstrumentsPositionBook;
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
                            AccountConfigurationBody.builder()
                                    .marginRate(BigDecimal.valueOf(0.001))
                                    .build());
                })
                .ifPresent(c -> System.out.println(c.getClientConfigureTransaction().getAlias()));

        InstrumentCandlesQuery build = InstrumentCandlesQuery.builder()
                .price(PriceType.ABM)
                .count(50)
                .granularity(CandlestickGranularity.S5)
                .build();

        getInstrumentsCandles.execute("EUR_USD", build)
                .getCandles()
                .stream()
                .flatMap(c -> Stream.of(c.getAsk(), c.getBid(), c.getBid()))
                .peek(c -> System.out.println(c.getHigh()))
                .max(Comparator.comparing(CandlestickData::getHigh))
                .ifPresent(c -> System.out.println(c.getHigh()));


        getInstrumentsOrderBook.execute("EUR_USD")
                .getOrderBook()
                .getBuckets()
                .stream()
                .max(Comparator.comparing(OrderBookBucket::getPrice))
                .ifPresent(c -> System.out.println(c.getPrice()));

        getInstrumentsPositionBook.execute("EUR_USD")
                .getPositionBook()
                .getBuckets()
                .stream()
                .max(Comparator.comparing(PositionBookBucket::getPrice))
                .ifPresent(c -> System.out.println(c.getPrice()));
    }
}
