package com.userService.service;

import com.netflix.discovery.converters.Auto;
import com.userService.entity.Hotel;
import com.userService.entity.Rating;
import com.userService.entity.User;
import com.userService.exception.ResourceNotFoundException;
import com.userService.external.services.HotelService;
import com.userService.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        // implementing Rating Service

        return userRepository.findAll();
    }


    public User updateUser(User updatedUser) {
        return userRepository.save(updatedUser);
    }

    // Delete
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User  not found with ID: " + userId));
        //fetching rating the above user from rating service
        // http://localhost:8083/ratings/users/1
        Rating[] rattingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
            logger.info("{} ",rattingOfUser);

        List<Rating> ratings = Arrays.stream(rattingOfUser).collect(Collectors.toList());

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //http://localhost:8082/hotels/1           hotel url3
        //    ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel=hotelService.getHotel(rating.getHotelId());
           // logger.info("Response ststus code ",forEntity.getStatusCode());
            //set hotel rating
            rating.setHotel(hotel);
            return rating;}).collect(Collectors.toList());

        user.setRating(String.valueOf(ratingList));
        return user;
    }


}
