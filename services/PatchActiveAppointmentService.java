package com.marcusvynicius.appoinment_management.services;

import com.marcusvynicius.appoinment_management.AppointmentEntity;
import com.marcusvynicius.appoinment_management.AppointmentRepository;
import com.marcusvynicius.appoinment_management.dto.PatchActiveDTO;
import com.marcusvynicius.appoinment_management.exceptions.AppointmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatchActiveAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentEntity execute(UUID id, PatchActiveDTO patchActiveDTO) {

        var appointment = this.appointmentRepository.findById(id).orElseThrow(() -> {
            throw new AppointmentNotFoundException();
        });

        appointment.setActive(patchActiveDTO.isActive());

        return this.appointmentRepository.save(appointment);
    }
}
