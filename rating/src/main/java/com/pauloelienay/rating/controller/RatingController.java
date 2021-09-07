package com.pauloelienay.rating.controller;

import com.pauloelienay.rating.model.Rating;
import com.pauloelienay.rating.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("ratings")
public class RatingController {

	@GetMapping("{userId}")
	public UserRating getRatingByMovieId(@PathVariable int userId) {
		List<Rating> ratings = Arrays.asList(
			new Rating(1, 4),
			new Rating(2, 2),
			new Rating(3, 1)
		);
		return UserRating.builder()
			.userId(userId)
			.ratings(ratings).build();
	}
}
