package com.userService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private long ratingId;
    private long userId;
    private  long hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;
}
