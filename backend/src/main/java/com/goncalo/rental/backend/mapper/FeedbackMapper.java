package com.goncalo.rental.backend.mapper;
import com.goncalo.rental.backend.model.dto.request.FeedbackRequest;
import com.goncalo.rental.backend.model.dto.response.FeedbackResponse;
import com.goncalo.rental.backend.model.entity.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    @Mapping(target = "leaseAgreementId", source = "leaseAgreement.id")
    @Mapping(target = "userId", source = "author.id")
    @Mapping(target = "fullName", expression = "java(feedBack.getAuthor().getFirstName() + \" \" + feedBack.getAuthor().getLastName())")
    FeedbackResponse toFeedbackResponse(Feedback feedback);
    @Mapping(target = "leaseAgreementId", source = "leaseAgreement.id")
    @Mapping(target = "userId", source = "author.id")
    @Mapping(target = "fullName", expression = "java(feedBack.getAuthor().getFirstName() + \" \" + feedBack.getAuthor().getLastName())")
    List<FeedbackResponse> toFeedbackResponseList(List<Feedback> feedbacks);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "leaseAgreement", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Feedback toEntity(FeedbackRequest feedbackRequest);
}
