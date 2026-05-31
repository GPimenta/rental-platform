package com.goncalo.rental.backend.mapper;

import com.goncalo.rental.backend.model.dto.request.RentalApplicationRequest;
import com.goncalo.rental.backend.model.dto.response.RentalApplicationResponse;
import com.goncalo.rental.backend.model.entity.RentalApplication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalApplicationMapper {
    RentalApplicationResponse toRentalApplicationResponse(RentalApplication rentalApplication);
    RentalApplication toEntity(RentalApplicationRequest rentalApplicationRequest);
}
