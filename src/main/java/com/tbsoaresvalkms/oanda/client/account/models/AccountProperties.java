package com.tbsoaresvalkms.oanda.client.account.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountProperties {
    private String id;
    private List<String> tags;
}
