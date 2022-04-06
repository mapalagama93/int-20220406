package com.hasitha.int20220405.entities;

import com.hasitha.int20220405.models.Quote;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuoteResponse {

    private Result quoteResponse;

    @Getter
    @Setter
    public static class Result {
        private List<Quote> result = new ArrayList<>();
    }
}
