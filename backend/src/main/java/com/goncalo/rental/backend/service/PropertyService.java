package com.goncalo.rental.backend.service;

import com.goncalo.rental.backend.mapper.PropertyMapper;
import com.goncalo.rental.backend.model.dto.request.PropertyRequest;
import com.goncalo.rental.backend.model.dto.response.PropertyResponse;
import com.goncalo.rental.backend.model.entity.Property;
import com.goncalo.rental.backend.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    private PropertyMapper propertyMapper;

    public List<PropertyResponse> getAllProperties() {
        List<Property> propertyList = propertyRepository.findAll();
        return propertyMapper.toPropertyResponseList(propertyList);
    }

    public PropertyResponse saveProperty(PropertyRequest propertyRequest) {
        Property property = propertyMapper.toProperty(propertyRequest);
        Property saved = propertyRepository.saveAndFlush(property);
        return propertyMapper.toPropertyResponse(saved);
    }

}
