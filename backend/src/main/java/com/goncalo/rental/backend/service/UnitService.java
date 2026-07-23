package com.goncalo.rental.backend.service;

import com.goncalo.rental.backend.mapper.UnitMapper;
import com.goncalo.rental.backend.model.dto.request.UnitRequest;
import com.goncalo.rental.backend.model.dto.response.UnitResponse;
import com.goncalo.rental.backend.model.entity.Property;
import com.goncalo.rental.backend.model.entity.Unit;
import com.goncalo.rental.backend.repository.PropertyRepository;
import com.goncalo.rental.backend.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitService {

    private final UnitRepository unitRepository;
    private final PropertyRepository propertyRepository;
    private final UnitMapper unitMapper;

    public List<UnitResponse> getAllUnits(Long propertyId) {
        if(!propertyRepository.existsById(propertyId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property id not found");
        }

        List<Unit> byPropertyId = unitRepository.findByPropertyId(propertyId);
        return unitMapper.toUnitListResponse(byPropertyId);
    }

    public UnitResponse createUnit(Long propertyId, UnitRequest unitRequest) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not Found"));

        Unit unit = unitMapper.toEntity(unitRequest);
        unit.setProperty(property);

        Unit unitSaved = unitRepository.saveAndFlush(unit);
        return unitMapper.toUnitResponse(unitSaved);

    }

    public UnitResponse putUnit(Long id, UnitRequest unitRequest) {

        Unit unitUpdated = unitRepository.findById(id).map(unit -> {
            unit.setName(unitRequest.getName());
            unit.setDescription(unitRequest.getDescription());
            unit.setPrice(unitRequest.getPrice());
            unit.setAvailable(unitRequest.getAvailable());
            return unitRepository.saveAndFlush(unit);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unit not found"));

        return unitMapper.toUnitResponse(unitUpdated);
    }
}
