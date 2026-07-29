package com.goncalo.rental.backend.mapper;

import com.goncalo.rental.backend.model.dto.request.RentalApplicationRequest;
import com.goncalo.rental.backend.model.dto.response.RentalApplicationResponse;
import com.goncalo.rental.backend.model.entity.RentalApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.lang.annotation.Target;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RentalApplicationMapper {

    @Mapping(target = "unitId",
            source = "unit.id")
    @Mapping(target = "fullName",
            expression = "java(rentalApplication.getUser() != null ?  rentalApplication.getUser().getFirstName() + \" \" + rentalApplication.getUser().getLastName(): null)")
    List<RentalApplicationResponse> toListRentalApplicationResponse(List<RentalApplication> rentalApplicationList);

    @Mapping(target = "unitId",
            source = "unit.id")
    @Mapping(target = "fullName",
            expression = "java(rentalApplication.getUser() != null ?  rentalApplication.getUser().getFirstName() + \" \" + rentalApplication.getUser().getLastName(): null)")
    RentalApplicationResponse toRentalApplicationResponse(RentalApplication rentalApplication);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "currentStatus", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    RentalApplication toEntity(RentalApplicationRequest rentalApplicationRequest);
}

