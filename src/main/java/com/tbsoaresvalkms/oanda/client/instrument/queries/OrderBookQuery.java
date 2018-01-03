package com.tbsoaresvalkms.oanda.client.instrument.queries;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class OrderBookQuery {
    private LocalDateTime time;
}
