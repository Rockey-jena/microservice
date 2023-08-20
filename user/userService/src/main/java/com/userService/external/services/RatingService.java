package com.userService.external.services;

import com.userService.entity.Rating;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    // get`

    //post
    @PostMapping("/ratings")
    public ResponseEntity<Rating> crateRating(Rating values);
    //put
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable  ("ratingId") long  ratingId, Rating rating);
    @DeleteMapping("/ratings/{ratingId}")
    public void delteRating(@PathVariable long ratingId);
}
