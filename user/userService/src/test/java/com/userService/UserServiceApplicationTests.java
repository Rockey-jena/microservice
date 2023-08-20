package com.userService;

import com.userService.entity.Rating;
import com.userService.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private RatingService ratingService;
//	@Test
//	void createRating(){
//		Rating rating=Rating.builder().rating(10).userId( 1).hotelId(1).feedback("this is reated using fign clint").build();
//		Rating saveRating = ratingService.crateRating(rating);
//		System.out.println("new Rating created");
//	}

}
