package com.goncalo.rental.backend.controller;

import com.goncalo.rental.backend.model.dto.request.RentalApplicationRequest;
import com.goncalo.rental.backend.model.dto.request.RentalApplicationStatusRequest;
import com.goncalo.rental.backend.model.dto.response.RentalApplicationResponse;
import com.goncalo.rental.backend.model.entity.RentalApplication;
import com.goncalo.rental.backend.service.RentalApplicationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class RentalApplicationController {

    private final RentalApplicationService rentalApplicationService;

    @GetMapping("/applications")
    public ResponseEntity<List<RentalApplicationResponse>> getRentalApplication() {
        return ResponseEntity.ok(rentalApplicationService.getAllApplications());
    }

    @PostMapping("units/{unitId}/applications")
    public ResponseEntity<RentalApplicationResponse> postRentalApplication(@PathVariable Long unitId/*, @Valid @RequestBody RentalApplicationRequest rentalApplicationRequest*/) {
        RentalApplicationResponse rentalApplicationResponse = rentalApplicationService.addApplication(unitId/*, rentalApplicationRequest*/);
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalApplicationResponse);
    }

    @PatchMapping("/applications/{id}/status")
    public ResponseEntity<RentalApplicationResponse> patchRentalApplication(@PathVariable Long id, @Valid @RequestBody RentalApplicationStatusRequest rentalApplicationStatusRequest) {
        return ResponseEntity.ok(rentalApplicationService.updateStatus(id, rentalApplicationStatusRequest));
    }
}
