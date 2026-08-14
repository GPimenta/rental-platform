package com.goncalo.rental.backend.service;

import com.goncalo.rental.backend.mapper.LeaseAgreementMapper;
import com.goncalo.rental.backend.model.dto.request.LeaseAgreementRequest;
import com.goncalo.rental.backend.model.dto.request.LeaseAgreementStatusRequest;
import com.goncalo.rental.backend.model.dto.response.LeaseAgreementResponse;
import com.goncalo.rental.backend.model.entity.LeaseAgreement;
import com.goncalo.rental.backend.model.entity.Unit;
import com.goncalo.rental.backend.model.entity.User;
import com.goncalo.rental.backend.repository.LeaseAgreementRepository;
import com.goncalo.rental.backend.repository.UnitRepository;
import com.goncalo.rental.backend.repository.UserRepository;
import com.goncalo.rental.backend.utils.ApplicationStatus;
import com.goncalo.rental.backend.utils.LeaseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaseAgreementService {

    private final LeaseAgreementRepository leaseAgreementRepository;
    private final UnitRepository unitRepository;
    private final UserRepository userRepository;
    private final LeaseAgreementMapper leaseAgreementMapper;

    public List<LeaseAgreementResponse> getListLeaseAgreements() {
        List<LeaseAgreement> all = leaseAgreementRepository.findAll();

        return leaseAgreementMapper.toListLeaseAgreementResponse(all);
    }

    public LeaseAgreementResponse getLeaseAgreement(Long id) {
        LeaseAgreement leaseAgreement = leaseAgreementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lease Agreement not found"));

        return leaseAgreementMapper.toLeaseAgreementResponse(leaseAgreement);
    }
//    /v1/units/{unitId}/lease-agreements

    public LeaseAgreementResponse addLeaseAgreement(Long unitId, LeaseAgreementRequest leaseAgreementRequest) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unit not found"));

        User user = userRepository.findById(leaseAgreementRequest.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));


        LeaseAgreement entity = leaseAgreementMapper.toEntity(leaseAgreementRequest);
        entity.setUnit(unit);
        entity.setUser(user);
        entity.setLeaseStatus(LeaseStatus.ACTIVE);

        LeaseAgreement leaseAgreement = leaseAgreementRepository.saveAndFlush(entity);

        return leaseAgreementMapper.toLeaseAgreementResponse(leaseAgreementRepository.saveAndFlush(leaseAgreement));
    }

    public LeaseAgreementResponse updateLeaseAgreementStatus(Long id, LeaseAgreementStatusRequest leaseAgreementStatusRequest) {
        LeaseAgreement leaseAgreement = leaseAgreementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "LeaseAgreement not found"));

        if (leaseAgreement.getLeaseStatus() != LeaseStatus.ACTIVE) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Only ACTIVE leases can be updated");
        }

        leaseAgreement.setLeaseStatus(leaseAgreementStatusRequest.getLeaseStatus());

        return leaseAgreementMapper.toLeaseAgreementResponse(leaseAgreementRepository.saveAndFlush(leaseAgreement));
    }

}
