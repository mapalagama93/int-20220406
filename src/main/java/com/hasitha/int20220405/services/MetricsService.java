package com.hasitha.int20220405.services;

import com.hasitha.int20220405.commons.Consts;
import com.hasitha.int20220405.entities.AnnualizedReturnResult;
import com.hasitha.int20220405.models.Quote;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MetricsService {

    @Autowired
    FinanceAPIService financeAPIService;

    /**
     * Calculate Annualized Return with following formula
     * Annualized Rate of Return = ((1 + Return ) ^ Period) − 1
     * Return = (endPrice − startPrice) ÷ startPrice (This code using closing price for both startPrice and endPrice)
     * Period = 365 ÷ holdingPeriodInDays
     *
     * @param symbol
     * @param duration
     */
    public AnnualizedReturnResult getAnnualizedReturn(String symbol, int duration) {
        log.info("get annualized return for symbol = {}, duration = {}", symbol, duration);
        double period = this.getPeriod(duration);
        double returnValue = this.getReturnValue(symbol);
        double annualizedReturn = Math.pow((1 + returnValue), period) - 1;
        return new AnnualizedReturnResult(symbol, duration, annualizedReturn);
    }

    private double getReturnValue(String symbol) {
        log.info("get return value for symbol = {}", symbol);
        Quote quote = this.financeAPIService.fetchQuote(symbol);
        double startPrice = quote.getRegularMarketDayLow();
        double endPrice = quote.getRegularMarketDayHigh();
        return (endPrice - startPrice) / startPrice;
    }

    private double getPeriod(int duration) {
        log.info("get period for duration = {}", duration);
        return Consts.DAYS_IN_YEAR / duration;
    }

}
