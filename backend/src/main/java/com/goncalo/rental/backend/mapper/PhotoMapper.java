package com.goncalo.rental.backend.mapper;

import com.goncalo.rental.backend.model.dto.request.PhotoRequest;
import com.goncalo.rental.backend.model.dto.response.PhotoResponse;
import com.goncalo.rental.backend.model.entity.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    @Mapping(target = "propertyId", source = "property.id")
    @Mapping(target = "userId", source = "user.id")
    PhotoResponse toPhotoResponse(Photo photo);
    @Mapping(target = "propertyId", source = "property.id")
    @Mapping(target = "userId", source = "user.id")
    List<PhotoResponse> toPhotoResponseList(List<Photo> photos);
    @Mapping(target = "property", ignore = true)
    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Photo toEntity(PhotoRequest photoRequest);
}
