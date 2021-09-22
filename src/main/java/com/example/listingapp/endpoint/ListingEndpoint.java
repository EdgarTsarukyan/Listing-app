package com.example.listingapp.endpoint;

import com.example.listingapp.entity.Listing;
import com.example.listingapp.entity.User;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ListingEndpoint {

    private final ListingService listingService;

    @GetMapping("/listings")
    public List<Listing> listings(){
        return listingService.findAllListings();
    }



    @GetMapping("/listings/{id}")
    public ResponseEntity<Listing> getListingsById(@PathVariable("id") int id) {
        Optional<Listing> byId = listingService.findListingsById(id);

        if (byId.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @GetMapping("/listings/byCategory/{CategoryId}")
    public List<Listing> getListingsByCategoryId(@PathVariable("CategoryId") int id) {
        List<Listing> byCategoryId = listingService.findListingsByCategoryId(id);

        return byCategoryId;
    }

    @GetMapping("/listings/byUser/{email}")
    public List<Listing> getListingsByEmail(@PathVariable("email") String email) {
       List<Listing> byEmail = listingService.findListingsByUserEmail(email);
        return byEmail;
    }



    @PostMapping("/listings")
    public ResponseEntity<Listing> listings(@RequestBody Listing listing) {
    return   listingService.addListing(listing);

    }

    @PutMapping("/listings")
    public ResponseEntity<Listing> putUser(@RequestBody Listing listing) {


        return listingService.addListing(listing);

    }

    @DeleteMapping("/listings/{id}")
    public ResponseEntity<Listing> deleteListing(@PathVariable("id") int id) {
        Optional<Listing> byId = listingService.findListingsById(id);

        if (byId.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        listingService.deleteListingById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
