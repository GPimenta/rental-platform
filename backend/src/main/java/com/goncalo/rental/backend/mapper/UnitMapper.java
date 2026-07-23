package com.goncalo.rental.backend.mapper;

import com.goncalo.rental.backend.model.dto.request.UnitRequest;
import com.goncalo.rental.backend.model.dto.response.UnitResponse;
import com.goncalo.rental.backend.model.entity.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UnitMapper {
    UnitResponse toUnitResponse(Unit unit);
    List<UnitResponse> toUnitListResponse(List<Unit> unitList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "property", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Unit toEntity(UnitRequest unitRequest);
}
