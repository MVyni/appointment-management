package com.marcusvynicius.appoinment_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAppointmentDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @NotBlank
    private String professional;
}
