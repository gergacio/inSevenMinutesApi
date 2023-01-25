package com.preslavsystem.preslavsystem.controllers;

import com.preslavsystem.preslavsystem.models.Booking;
import com.preslavsystem.preslavsystem.repositories.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    @Autowired
    IBookingRepository bookingRepository;
    //REST
    //SHOW
    //http://localhost:8080/bookings (get custom method)
    @GetMapping
    public ResponseEntity getBookingsWithFilter(){

        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }
    //SHOW_BY_ID
    //http://localhost:8080/bookings/1 (get custom method)
    @GetMapping(value = "/{id}")
    public ResponseEntity getBookingById(@PathVariable Long id){

        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    //CREATE
    //http://localhost:8080/bookings/ (post custom method)
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        //save it to H2
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
    //UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable Long id){
        Booking foundBookingToUpdate = bookingRepository.findById(id).get();
        foundBookingToUpdate.setDate(booking.getDate());
        foundBookingToUpdate.setCourse(booking.getCourse());
        foundBookingToUpdate.setStudent(booking.getStudent());

        bookingRepository.save(foundBookingToUpdate);
        return new ResponseEntity<>(foundBookingToUpdate, HttpStatus.CREATED);
    }
    //REMOVE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> removeBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
