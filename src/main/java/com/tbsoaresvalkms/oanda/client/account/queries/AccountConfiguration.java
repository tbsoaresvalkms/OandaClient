package com.tbsoaresvalkms.oanda.client.account.queries;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tbsoaresvalkms.oanda.client.core.convert.BigDecimalToJsonConvert;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountConfiguration {
    private String alias;
    @JsonSerialize(using = BigDecimalToJsonConvert.class)
    private BigDecimal marginRate;
}
