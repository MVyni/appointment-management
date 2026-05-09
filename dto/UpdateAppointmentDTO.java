package com.marcusvynicius.appoinment_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
public class UpdateAppointmentDTO {

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Category is required.")
    private String category;

    @NotBlank(message = "Professional is required.")
    private String professional;
}
