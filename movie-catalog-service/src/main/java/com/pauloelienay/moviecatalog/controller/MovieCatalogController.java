package com.pauloelienay.moviecatalog.controller;

import com.pauloelienay.moviecatalog.model.CatalogItem;
import com.pauloelienay.moviecatalog.model.Movie;
import com.pauloelienay.moviecatalog.model.Rating;
import com.pauloelienay.moviecatalog.model.UserRating;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalog")
@Slf4j
public class MovieCatalogController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/users/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable int userId) {

        List<Rating> ratings = Objects.requireNonNull(restTemplate
                .getForObject("http://localhost:8002/ratings/" + userId,
                UserRating.class)).getRatings();

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8001/movies/" + rating.getMovieId(),
                    Movie.class);
            log.info(movie.toString());
            return new CatalogItem(movie.getTitle(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
