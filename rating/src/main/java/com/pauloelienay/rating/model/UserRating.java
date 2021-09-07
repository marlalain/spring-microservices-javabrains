package com.pauloelienay.rating.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserRating {
	private int userId;
	private List<Rating> ratings;
}
