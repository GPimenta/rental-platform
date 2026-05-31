package com.goncalo.rental.backend.mapper;

import com.goncalo.rental.backend.model.dto.request.PropertyRequest;
import com.goncalo.rental.backend.model.dto.response.PropertyResponse;
import com.goncalo.rental.backend.model.entity.Property;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    PropertyResponse toPropertyResponse(Property property);
    Property toEntity(PropertyRequest propertyRequest);
}
