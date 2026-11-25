
package com.durava.duravanews;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    // Get all news
    @GetMapping
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    // Add news
    @PostMapping
    public News addNews(@RequestBody News news) {
        return newsRepository.save(news);
    }

    // Get news by ID
    @GetMapping("/{id}")
    public News getNewsById(@PathVariable Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    // Delete news
    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsRepository.deleteById(id);
    }
}
