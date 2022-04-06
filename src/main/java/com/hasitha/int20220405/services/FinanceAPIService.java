package com.hasitha.int20220405.services;

import com.hasitha.int20220405.models.Quote;

public interface FinanceAPIService {
    public Quote fetchQuote(String symbol);
}
