package com.goncalo.rental.backend.mapper;
import com.goncalo.rental.backend.model.dto.request.LeaseAgreementRequest;
import com.goncalo.rental.backend.model.dto.request.LeaseAgreementStatusRequest;
import com.goncalo.rental.backend.model.dto.response.LeaseAgreementResponse;
import com.goncalo.rental.backend.model.entity.LeaseAgreement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeaseAgreementMapper {
    @Mapping(target = "userId",
            source = "user.id")
    @Mapping(target = "unitId",
            source = "unit.id")
    LeaseAgreementResponse toLeaseAgreementResponse(LeaseAgreement leaseAgreement);

    @Mapping(target = "userId",
            source = "user.id")
    @Mapping(target = "unitId",
            source = "unit.id")
    List<LeaseAgreementResponse> toListLeaseAgreementResponse(List<LeaseAgreement> leaseAgreements);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "leaseStatus", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    LeaseAgreement toEntity(LeaseAgreementRequest leaseAgreementRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "startDate", ignore = true)
    @Mapping(target = "endDate", ignore = true)
    @Mapping(target = "rentAmount", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    LeaseAgreement toEntity(LeaseAgreementStatusRequest leaseAgreementStatusRequest);
}
