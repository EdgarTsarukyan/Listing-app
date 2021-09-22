package com.example.listingapp.service.impl;

import com.example.listingapp.entity.Listing;
import com.example.listingapp.repository.ListingRepository;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    @Override
    public List<Listing> findAllListings() {
        return listingRepository.findAll();
    }

    @Override
    public List<Listing> findListingsByUserEmail(String email) {
        return listingRepository.findAllByUserEmail(email);
    }

    @Override
    public List<Listing> findListingsByCategoryId(int id) {
        return listingRepository.findAllByCategoryId(id);
    }

    @Override
    public Optional<Listing> findListingsById(int id) {
        return listingRepository.findById(id);
    }

    @Override
    public ResponseEntity<Listing> addListing(Listing listing) {
        listingRepository.save(listing);

        Optional<Listing> byId = listingRepository.findById(listing.getId());

        if (byId.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        listingRepository.save(listing);

        return ResponseEntity
                .ok()
                .body(listingRepository.save(listing));
    }

    @Override
    public void deleteListingById(int id) {
        listingRepository.deleteById(id);
    }
}
