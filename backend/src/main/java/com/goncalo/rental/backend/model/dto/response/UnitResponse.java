package com.goncalo.rental.backend.model.dto.response;

import com.goncalo.rental.backend.model.entity.Property;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UnitResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean available;
    private LocalDateTime createdAt;
}
