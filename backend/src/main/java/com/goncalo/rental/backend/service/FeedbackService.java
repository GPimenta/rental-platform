package com.goncalo.rental.backend.service;

import com.goncalo.rental.backend.mapper.FeedbackMapper;
import com.goncalo.rental.backend.model.dto.request.FeedbackRequest;
import com.goncalo.rental.backend.model.dto.response.FeedbackResponse;
import com.goncalo.rental.backend.model.entity.Feedback;
import com.goncalo.rental.backend.model.entity.LeaseAgreement;
import com.goncalo.rental.backend.model.entity.User;
import com.goncalo.rental.backend.repository.FeedbackRepository;
import com.goncalo.rental.backend.repository.LeaseAgreementRepository;
import com.goncalo.rental.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final LeaseAgreementRepository leaseAgreementRepository;
    private final UserRepository userRepository;
    private final FeedbackMapper feedbackMapper;

    public List<FeedbackResponse> getFeedback(Long leaseId) {
        if(!leaseAgreementRepository.existsById(leaseId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "LeaseAgreement id not found");
        }

        List<Feedback> feedbackList = feedbackRepository.findLeaseById(leaseId);

        return feedbackMapper.toFeedbackResponseList(feedbackList);
    }

    public FeedbackResponse addFeedback(Long leaseId, FeedbackRequest feedbackRequest) {
        LeaseAgreement leaseAgreement = leaseAgreementRepository.findById(leaseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Lease Id not found"));
        User user = userRepository.findById(feedbackRequest.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Feedback entity = feedbackMapper.toEntity(feedbackRequest);
        entity.setLeaseAgreement(leaseAgreement);
        entity.setAuthor(user);

        return feedbackMapper.toFeedbackResponse(feedbackRepository.saveAndFlush(entity));

    }
}
