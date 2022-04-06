package com.hasitha.int20220405.services;

import com.hasitha.int20220405.entities.QuoteResponse;
import com.hasitha.int20220405.exceptions.QuoteNotFoundException;
import com.hasitha.int20220405.models.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class YahooFinanceAPIService implements FinanceAPIService {

    @Value("${app.yahoo-finance-api-key}")
    private String yahooFinanceApiKey;

    private static final String BASE_URL = "https://yfapi.net/v6";
    private static final String QUOTE = "/finance/quote?region=US&lang=en&symbols=";

    @Override
    public Quote fetchQuote(String symbol) {
        String url = BASE_URL + QUOTE + symbol;
        log.info("fetch quote from url = {}", url);
        HttpEntity<Void> requestEntity = new HttpEntity<>(getHeaders());
        ResponseEntity<QuoteResponse> response = new RestTemplate().exchange(url, HttpMethod.GET, requestEntity, QuoteResponse.class);
        List<Quote> quotes = response.getBody().getQuoteResponse().getResult();
        if(quotes.size() <= 0) {
            throw new QuoteNotFoundException();
        }
        return quotes.get(0);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", yahooFinanceApiKey);
        return headers;
    }
}
