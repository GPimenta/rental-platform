package com.goncalo.rental.backend.mapper;
import com.goncalo.rental.backend.model.dto.response.LeaseAgreementResponse;
import com.goncalo.rental.backend.model.entity.LeaseAgreement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaseAgreementMapper {
    LeaseAgreementResponse toLeaseAgreementResponse(LeaseAgreement leaseAgreement);
    LeaseAgreement toEntity(LeaseAgreement leaseAgreement);
}
