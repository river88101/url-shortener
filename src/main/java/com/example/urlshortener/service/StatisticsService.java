package com.example.urlshortener.service;

import com.example.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    @Autowired
    private UrlRepository urlRepository;

    public long getTotalShortenedUrls() {
        return urlRepository.count();
    }

}
