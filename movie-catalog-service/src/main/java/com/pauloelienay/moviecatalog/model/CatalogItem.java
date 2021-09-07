package com.pauloelienay.moviecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CatalogItem {
    private String name;
    private String description;
    private int rating;
}
