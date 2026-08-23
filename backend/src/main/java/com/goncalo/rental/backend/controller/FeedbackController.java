package com.goncalo.rental.backend.controller;

import com.goncalo.rental.backend.model.dto.request.FeedbackRequest;
import com.goncalo.rental.backend.model.dto.response.FeedbackResponse;
import com.goncalo.rental.backend.service.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @GetMapping("/lease-agreements/{leaseId}/feedback")
    public ResponseEntity<List<FeedbackResponse>> getFeedback(@PathVariable Long leaseId) {
        return ResponseEntity.ok(feedbackService.getFeedback(leaseId));
    }

    @PostMapping("/lease-agreements/{leaseId}/feedback")
    public ResponseEntity<FeedbackResponse> addFeedback(@PathVariable Long leaseId, @Valid @RequestBody FeedbackRequest feedbackRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.addFeedback(leaseId, feedbackRequest));
    }
}
