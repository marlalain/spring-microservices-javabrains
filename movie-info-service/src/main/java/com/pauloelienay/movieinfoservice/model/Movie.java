package com.pauloelienay.movieinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Movie {
    private long id;
    private String title;
    private String description;
}
