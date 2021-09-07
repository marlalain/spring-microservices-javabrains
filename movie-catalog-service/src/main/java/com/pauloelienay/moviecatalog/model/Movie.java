package com.pauloelienay.moviecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
	private int id;
	private String title;
	private String description;
}
