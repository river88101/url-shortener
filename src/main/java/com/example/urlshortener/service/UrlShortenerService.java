package com.example.urlshortener.service;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlRepository urlRepository;

    private final String BASE_URL = "http://short.url/";
    private final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Random random = new Random();

    public String shortenUrl(String originalUrl) {
        Optional<Url> existingUrl = urlRepository.findByOriginalUrl(originalUrl);
        if (existingUrl.isPresent()) {
            return existingUrl.get().getShortUrl();
        }

        String shortUrl = generateShortUrl();
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(BASE_URL + shortUrl);
        url.setCreatedDate(LocalDateTime.now());
        urlRepository.save(url);
        return url.getShortUrl();
    }

    public String getOriginalUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl)
                .map(Url::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }

    private String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            shortUrl.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return shortUrl.toString();
    }
}
