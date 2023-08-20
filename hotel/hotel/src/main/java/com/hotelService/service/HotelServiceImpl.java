package com.hotelService.service;

import com.hotelService.entity.Hotel;
import com.hotelService.exception.ResourceNotFoundException;
import com.hotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;


    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }


public Hotel getHotelById(long hotelId) {
    return hotelRepository.findById(hotelId)
            .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + hotelId));
}

   public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(long hotelId, Hotel updatedHotel) {
        if (hotelRepository.existsById(hotelId)) {
            updatedHotel.setHotelId(hotelId);
            return hotelRepository.save(updatedHotel);
        }
        return null; // Hotel not found
    }

    public boolean deleteHotel(long hotelId) {
        if (hotelRepository.existsById(hotelId)) {
            hotelRepository.deleteById(hotelId);
            return true;
        }
        return false; // Hotel not found
    }
}
