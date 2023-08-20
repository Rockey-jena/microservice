package com.ratingService.service;

import com.ratingService.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating>getRating();
    List<Rating>getRatingByUserId(long userId);
    List<Rating>getRatingByHotelId(long hotelID);
}
