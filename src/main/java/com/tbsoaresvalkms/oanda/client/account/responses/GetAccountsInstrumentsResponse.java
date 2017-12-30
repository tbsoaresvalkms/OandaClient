package com.tbsoaresvalkms.oanda.client.account.responses;

import com.tbsoaresvalkms.oanda.client.instrument.models.Instrument;
import lombok.Getter;

import java.util.List;

@Getter
public class GetAccountsInstrumentsResponse {
    private List<Instrument> instruments;
    private String lastTransactionID;
}
