package com.hasitha.int20220405.controllers;

import com.hasitha.int20220405.entities.AnnualizedReturnResult;
import com.hasitha.int20220405.services.MetricsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    @GetMapping("/metrics/annualized-return")
    public ResponseEntity<AnnualizedReturnResult> getAnnualizedReturn(@RequestParam("symbol") String symbol,
                                                                      @RequestParam("duration") int duration) {
        log.info("get annualized return for symbol = {}, duration = {}", symbol, duration);
        AnnualizedReturnResult annualizedReturn = this.metricsService.getAnnualizedReturn(symbol, duration);
        return ResponseEntity.ok(annualizedReturn);
    }
}
