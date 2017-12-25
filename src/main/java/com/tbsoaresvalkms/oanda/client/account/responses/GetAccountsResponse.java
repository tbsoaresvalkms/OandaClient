package com.tbsoaresvalkms.oanda.client.account.responses;

import com.tbsoaresvalkms.oanda.client.account.models.AccountProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GetAccountsResponse {
    private List<AccountProperties> accounts;
}
