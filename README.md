## Usage

1. To shorten a URL, POST `api/shorten` endpoint and provide the original URL in json request e.g
 {
      "originalUrl": "http://example.com"
  }
2. To retrieve the original URL from a shortened URL, GET /api/{shortUrl} endpoint
3. To gather statistics for a URL shortener application, GET /api/statistics/total: Retrieves the total number of shortened URLs.
