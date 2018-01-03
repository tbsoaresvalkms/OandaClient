package com.tbsoaresvalkms.oanda.client.instrument.queries;

import com.tbsoaresvalkms.oanda.client.instrument.models.CandlestickGranularity;
import com.tbsoaresvalkms.oanda.client.instrument.models.PriceType;
import com.tbsoaresvalkms.oanda.client.instrument.models.WeeklyAlignment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class InstrumentCandlesQuery {
    private PriceType price;
    private CandlestickGranularity granularity;
    private Integer count;
    private LocalDateTime from;
    private LocalDateTime to;
    private Boolean smooth;
    private Boolean includeFirst;
    private Integer dailyAlignment;
    private String alignmentTimezone;
    private WeeklyAlignment weeklyAlignment;
}
