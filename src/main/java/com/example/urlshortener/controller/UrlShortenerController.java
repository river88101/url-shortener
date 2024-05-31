package com.example.urlshortener.controller;

import com.example.urlshortener.service.StatisticsService;
import com.example.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {
    @Autowired
    private UrlShortenerService urlShortenerService;

    private StatisticsService statisticsService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String originalUrl) {
        String shortUrl = urlShortenerService.shortenUrl(originalUrl);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = urlShortenerService.getOriginalUrl("http://short.url/" + shortUrl);
        return ResponseEntity.ok(originalUrl);
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalShortenedUrls() {
        long total = statisticsService.getTotalShortenedUrls();
        return ResponseEntity.ok(total);
    }
}
