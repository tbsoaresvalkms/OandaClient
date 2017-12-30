package com.tbsoaresvalkms.oanda.client.account.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
public class AccountProperties {
    private String id;
    private List<String> tags;
}
