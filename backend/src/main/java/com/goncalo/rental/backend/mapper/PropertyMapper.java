package com.goncalo.rental.backend.mapper;

import com.goncalo.rental.backend.model.dto.request.PropertyRequest;
import com.goncalo.rental.backend.model.dto.response.PropertyResponse;
import com.goncalo.rental.backend.model.entity.Property;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    PropertyResponse toPropertyResponse(Property property);
    Property toProperty(PropertyRequest propertyRequest);
    List<PropertyResponse> toPropertyResponseList(List<Property> propertyList);
    List<Property> toPropertyList(List<PropertyRequest> propertyRequestList);

    PropertyRequest toPropertyRequest(Property property);
}
