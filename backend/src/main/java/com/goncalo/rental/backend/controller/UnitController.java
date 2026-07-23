package com.goncalo.rental.backend.controller;

import com.goncalo.rental.backend.model.dto.request.UnitRequest;
import com.goncalo.rental.backend.model.dto.response.UnitResponse;
import com.goncalo.rental.backend.service.UnitService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class UnitController {

    private final UnitService unitService;

    @GetMapping("/properties/{id}/units")
    public ResponseEntity<List<UnitResponse>> getAllUnits(@PathVariable Long id) {
        return ResponseEntity.ok(unitService.getAllUnits(id));
    }

    @PostMapping("/properties/{id}/units")
    public ResponseEntity<UnitResponse> createUnit(@PathVariable Long id, @Valid @RequestBody UnitRequest unitRequest) {
        UnitResponse unitResponse = unitService.createUnit(id, unitRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(unitResponse);
    }

    @PatchMapping("/unit/{id}")
    public ResponseEntity<UnitResponse> putUnit(@PathVariable Long id, @Valid @RequestBody UnitRequest unitRequest) {
        UnitResponse unitResponse = unitService.putUnit(id, unitRequest);
        return ResponseEntity.ok(unitResponse);
    }




}
