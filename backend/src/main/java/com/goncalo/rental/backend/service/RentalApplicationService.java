package com.goncalo.rental.backend.service;

import com.goncalo.rental.backend.mapper.RentalApplicationMapper;
import com.goncalo.rental.backend.model.dto.request.RentalApplicationStatusRequest;
import com.goncalo.rental.backend.model.dto.response.RentalApplicationResponse;
import com.goncalo.rental.backend.model.entity.RentalApplication;
import com.goncalo.rental.backend.model.entity.Unit;
import com.goncalo.rental.backend.repository.RentalApplicationRepository;
import com.goncalo.rental.backend.repository.UnitRepository;
import com.goncalo.rental.backend.utils.ApplicationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalApplicationService {

    private final RentalApplicationRepository rentalApplicationRepository;
    private final UnitRepository unitRepository;
    private final RentalApplicationMapper rentalApplicationMapper;

    public List<RentalApplicationResponse> getAllApplications() {
        List<RentalApplication> all = rentalApplicationRepository.findAll();

        return rentalApplicationMapper.toListRentalApplicationResponse(all);
    }

    public RentalApplicationResponse addApplication(Long unitId/*, RentalApplicationRequest rentalApplicationRequest*/) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unit not found"));

//        RentalApplication rentalApplication = rentalApplicationMapper.toEntity(rentalApplicationRequest);
        RentalApplication rentalApplication = new RentalApplication();
        rentalApplication.setUnit(unit);
        rentalApplication.setCurrentStatus(ApplicationStatus.PENDING);
        System.out.println(rentalApplication);

        RentalApplication rentalApplicationSaved = rentalApplicationRepository.saveAndFlush(rentalApplication);
        return rentalApplicationMapper.toRentalApplicationResponse(rentalApplicationSaved);
    }

    public RentalApplicationResponse updateStatus(Long id, RentalApplicationStatusRequest rentalApplicationStatusRequest) {
        RentalApplication rentalApplication = rentalApplicationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found"));

        if (rentalApplication.getCurrentStatus() != ApplicationStatus.PENDING) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, " Only pending applications can be reviewed");
        }

        rentalApplication.setCurrentStatus(rentalApplicationStatusRequest.getCurrentStatus());
        RentalApplication saved = rentalApplicationRepository.saveAndFlush(rentalApplication);
        return rentalApplicationMapper.toRentalApplicationResponse(saved);
    }
}
