package com.goncalo.rental.backend.mapper;

import com.goncalo.rental.backend.model.dto.request.UnitRequest;
import com.goncalo.rental.backend.model.dto.response.UnitResponse;
import com.goncalo.rental.backend.model.entity.Unit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnitMapper {
    UnitResponse toUnitResponse(Unit unit);
    Unit toEntity(UnitRequest unitRequest);
}
