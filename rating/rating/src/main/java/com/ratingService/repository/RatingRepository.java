package com.ratingService.repository;

import com.ratingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    // custom find method - when method not found u make custom method

    List<Rating>findByUserId(long userId);
    List<Rating>findByHotelId(long hotelId);
}
