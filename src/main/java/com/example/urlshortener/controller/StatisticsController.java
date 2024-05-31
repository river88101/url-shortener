package com.example.urlshortener.controller;

import com.example.urlshortener.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalShortenedUrls() {
        long total = statisticsService.getTotalShortenedUrls();
        return ResponseEntity.ok(total);
    }

}
