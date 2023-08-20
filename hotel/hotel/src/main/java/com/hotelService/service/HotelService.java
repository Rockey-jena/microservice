package com.hotelService.service;

import com.hotelService.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

   Hotel getHotelById(long hotelId);

    Hotel createHotel(Hotel hotel);

    Hotel updateHotel(long hotelId, Hotel updatedHotel);

    boolean deleteHotel(long hotelId);
}
