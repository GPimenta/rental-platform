package com.goncalo.rental.backend.mapper;
import com.goncalo.rental.backend.model.dto.request.LeaseAgreementRequest;
import com.goncalo.rental.backend.model.dto.response.LeaseAgreementResponse;
import com.goncalo.rental.backend.model.entity.LeaseAgreement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LeaseAgreementMapper {
    LeaseAgreementResponse toLeaseAgreementResponse(LeaseAgreement leaseAgreement);

    @Mapping(target = "leaseStatus", ignore = true)
    LeaseAgreement toEntity(LeaseAgreementRequest leaseAgreementRequest);
}
