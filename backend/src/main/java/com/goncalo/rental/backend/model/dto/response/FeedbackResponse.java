package com.goncalo.rental.backend.model.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackResponse {
    private Long id;
    private Long leaseAgreementId;
    private Long userId;
    private String fullName;
    private String message;
}
