package com.goncalo.rental.backend.controller;

import com.goncalo.rental.backend.model.dto.request.LeaseAgreementRequest;
import com.goncalo.rental.backend.model.dto.request.LeaseAgreementStatusRequest;
import com.goncalo.rental.backend.model.dto.response.LeaseAgreementResponse;
import com.goncalo.rental.backend.service.LeaseAgreementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class LeaseAgreementController {

    private final LeaseAgreementService leaseAgreementService;

    @GetMapping("/lease-agreements")
    public ResponseEntity<List<LeaseAgreementResponse>> getListLeaseAgreements() {
        return ResponseEntity.ok(leaseAgreementService.getListLeaseAgreements());
    }

    @GetMapping("/lease-agreements/{id}")
    public ResponseEntity<LeaseAgreementResponse> getLeaseAgreement(@PathVariable Long id) {
        return ResponseEntity.ok(leaseAgreementService.getLeaseAgreement(id));
    }

    @PostMapping("/units/{unitId}/lease-agreements")
    public ResponseEntity<LeaseAgreementResponse> postLeaseAgreement(@PathVariable Long unitId, @Valid @RequestBody LeaseAgreementRequest leaseAgreementRequest) {
        LeaseAgreementResponse leaseAgreementResponse = leaseAgreementService.addLeaseAgreement(unitId, leaseAgreementRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(leaseAgreementResponse);
    }

    @PatchMapping("/lease-agreements/{id}/status")
    public ResponseEntity<LeaseAgreementResponse> patchStatusLeaseAgreement(@PathVariable Long id, @Valid @RequestBody LeaseAgreementStatusRequest leaseAgreementStatusRequest) {
        return ResponseEntity.ok(leaseAgreementService.updateLeaseAgreementStatus(id, leaseAgreementStatusRequest));
    }
}
