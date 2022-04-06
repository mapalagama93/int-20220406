package com.hasitha.int20220405.unit;

import com.hasitha.int20220405.models.Quote;
import com.hasitha.int20220405.services.YahooFinanceAPIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Objects;

@SpringBootTest
class YahooFinanceAPIServiceTest {

	@Autowired
	YahooFinanceAPIService yahooFinanceAPIService;

	@Test
	void testFetchQuoteFetch_Success() {
		Quote quote = yahooFinanceAPIService.fetchQuote("AAPL");
		Assert.isTrue(Objects.equals(quote.getSymbol(), "AAPL"), "symbol is not equal");
	}

	@Test
	void testFetchQuoteFetch_Fail() {
		Quote quote = yahooFinanceAPIService.fetchQuote("AAPL");
		Assert.isTrue(!Objects.equals(quote.getSymbol(), "MSFT"), "symbol is equal");
	}

}
