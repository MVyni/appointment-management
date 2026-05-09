package com.marcusvynicius.appoinment_management.services;

import com.marcusvynicius.appoinment_management.AppointmentRepository;
import com.marcusvynicius.appoinment_management.exceptions.AppointmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void execute(UUID id) {

        var appointment = this.appointmentRepository.findById(id).orElseThrow(() -> {
            throw new AppointmentNotFoundException();
        });

        this.appointmentRepository.delete(appointment);
    }
}
