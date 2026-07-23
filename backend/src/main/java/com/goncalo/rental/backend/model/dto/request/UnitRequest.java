package com.goncalo.rental.backend.model.dto.request;

import com.goncalo.rental.backend.model.entity.Property;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class UnitRequest {

    @NotBlank(message = "Name is required!")
    @Size(max = 100, message = "Must not exceed 100 chars")
    private String name;
    private String description;
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;
    @NotNull(message = "Availability is required!")
    private Boolean available;

}
