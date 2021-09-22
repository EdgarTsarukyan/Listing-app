package com.example.listingapp.service;

import com.example.listingapp.entity.Listing;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ListingService {

    List<Listing> findAllListings();

    List<Listing> findListingsByUserEmail(String email);

    List<Listing> findListingsByCategoryId(int id);

    Optional<Listing> findListingsById(int id);

    ResponseEntity<Listing> addListing(Listing listing);

    void deleteListingById(int id);


}
