package com.pauloelienay.moviecatalog.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
    private int id;
    private String title;
    private String description;
}
