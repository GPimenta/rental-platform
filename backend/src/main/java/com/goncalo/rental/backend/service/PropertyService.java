package com.goncalo.rental.backend.service;

import com.goncalo.rental.backend.mapper.PropertyMapper;
import com.goncalo.rental.backend.model.dto.request.PropertyRequest;
import com.goncalo.rental.backend.model.dto.response.PropertyResponse;
import com.goncalo.rental.backend.model.entity.Property;
import com.goncalo.rental.backend.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    public List<PropertyResponse> getAllProperties() {
        List<Property> propertyList = propertyRepository.findAll();
        return propertyMapper.toPropertyResponseList(propertyList);
    }

    public Optional<PropertyResponse> getPropertyById(Long id) {
        return propertyRepository.findById(id).map(propertyMapper::toPropertyResponse);
    }

    public PropertyResponse saveProperty(PropertyRequest propertyRequest) {
        Property property = propertyMapper.toProperty(propertyRequest);
        Property saved = propertyRepository.saveAndFlush(property);
        return propertyMapper.toPropertyResponse(saved);
    }

    public PropertyResponse putProperty(Long id, PropertyRequest propertyRequest) {
        Property propertyUpdate = propertyMapper.toProperty(propertyRequest);

        Property propertyUpdated = propertyRepository.findById(id).map(property -> {
            property.setName(propertyUpdate.getName());
            property.setAddress(propertyUpdate.getAddress());
            property.setDescription(propertyUpdate.getDescription());
            return propertyRepository.saveAndFlush(property);
        }).orElseGet(() -> propertyRepository.saveAndFlush(propertyUpdate));

        return propertyMapper.toPropertyResponse(propertyUpdated);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
