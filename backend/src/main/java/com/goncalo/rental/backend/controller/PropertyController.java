package com.goncalo.rental.backend.controller;

import com.goncalo.rental.backend.model.dto.request.PropertyRequest;
import com.goncalo.rental.backend.model.dto.response.PropertyResponse;
import com.goncalo.rental.backend.repository.PropertyRepository;
import com.goncalo.rental.backend.service.PropertyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/properties")
@AllArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping
    public ResponseEntity<List<PropertyResponse>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyResponse> getProperty(@PathVariable Long id) {
        try {
            Optional<PropertyResponse> propertyById = propertyService.getPropertyById(id);
            return propertyById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<PropertyResponse> createProperty(@Valid @RequestBody PropertyRequest propertyRequest) {
        PropertyResponse propertyResponse = propertyService.saveProperty(propertyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyResponse> updateProperty(@PathVariable Long id, @Valid @RequestBody PropertyRequest propertyRequest) {
        try {
            return ResponseEntity.ok(propertyService.putProperty(id, propertyRequest));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PropertyResponse> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);

        if (propertyService.getPropertyById(id).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
