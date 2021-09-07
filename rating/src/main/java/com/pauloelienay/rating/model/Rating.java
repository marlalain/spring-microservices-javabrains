package com.pauloelienay.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Rating {
    private int movieId;
    private int rating;
}
