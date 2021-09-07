package com.pauloelienay.moviecatalog.controller;

import com.pauloelienay.moviecatalog.model.CatalogItem;
import com.pauloelienay.moviecatalog.model.Movie;
import com.pauloelienay.moviecatalog.model.Rating;
import com.pauloelienay.moviecatalog.model.UserRating;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
			.getForObject("http://rating-service/ratings/" + userId,
				UserRating.class)).getRatings();

		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
				Movie.class);
			log.info(movie.toString());
			return new CatalogItem(movie.getTitle(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
