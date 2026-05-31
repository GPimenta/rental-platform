package com.goncalo.rental.backend.mapper;
import com.goncalo.rental.backend.model.dto.request.FeedbackRequest;
import com.goncalo.rental.backend.model.dto.response.FeedbackResponse;
import com.goncalo.rental.backend.model.entity.Feedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    FeedbackResponse toFeedbackResponse(Feedback feedback);
    Feedback toEntity(FeedbackRequest feedbackRequest);
}
