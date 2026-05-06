package com.marcusvynicius.appoinment_management.controllers;

import com.marcusvynicius.appoinment_management.AppointmentEntity;
import com.marcusvynicius.appoinment_management.services.CreateAppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class CreateAppointmentController {

    @Autowired
    private CreateAppointmentService createAppointmentService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody AppointmentEntity appointmentEntity) {

        try {

            var result = this.createAppointmentService.execute(appointmentEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
