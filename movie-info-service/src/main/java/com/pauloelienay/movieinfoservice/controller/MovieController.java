package com.pauloelienay.movieinfoservice.controller;

import com.pauloelienay.movieinfoservice.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
@Slf4j
public class MovieController {
    @GetMapping("{id}")
    public Movie getMovie(@PathVariable long id) {
        Movie movie = new Movie(id, "Transformers", "It's about robots");
        log.info(movie.toString());
        return movie;
    }
}
