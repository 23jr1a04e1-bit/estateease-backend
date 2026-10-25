package com.estateease.estateease_backend;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(originPatterns = "https://*.vercel.app")
public class PropertyController {

    private final List<Map<String, Object>> properties = List.of(
        Map.ofEntries(
            Map.entry("id", 1),
            Map.entry("title", "Modern 3BHK Villa with Garden"),
            Map.entry("location", "Whitefield, Bengaluru"),
            Map.entry("city", "Bengaluru"),
            Map.entry("type", "Villa"),
            Map.entry("listingType", "buy"),
            Map.entry("price", 12500000),
            Map.entry("area", 185),
            Map.entry("bedrooms", 3),
            Map.entry("bathrooms", 3),
            Map.entry("image", "https://images.pexels.com/photos/7031406/pexels-photo-7031406.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"),
            Map.entry("description", "A modern villa in a gated community."),
            Map.entry("amenities", List.of("Garden", "Parking", "Security"))
        ),
        Map.ofEntries(
            Map.entry("id", 2),
            Map.entry("title", "Cozy 2BHK Apartment for Rent"),
            Map.entry("location", "Koramangala, Bengaluru"),
            Map.entry("city", "Bengaluru"),
            Map.entry("type", "Apartment"),
            Map.entry("listingType", "rent"),
            Map.entry("price", 38000),
            Map.entry("area", 95),
            Map.entry("bedrooms", 2),
            Map.entry("bathrooms", 2),
            Map.entry("image", "https://images.pexels.com/photos/8089172/pexels-photo-8089172.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"),
            Map.entry("description", "A comfortable apartment for rent."),
            Map.entry("amenities", List.of("Furnished", "Lift", "Security"))
        )
    );

    @GetMapping
    public List<Map<String, Object>> getProperties() {
        return properties;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getPropertyById(@PathVariable int id) {
        return properties.stream()
            .filter(property -> property.get("id").equals(id))
            .findFirst()
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Property not found"
                )
            );
    }
}