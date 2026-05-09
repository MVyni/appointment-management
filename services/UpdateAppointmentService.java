package com.marcusvynicius.appoinment_management.services;

import com.marcusvynicius.appoinment_management.AppointmentEntity;
import com.marcusvynicius.appoinment_management.AppointmentRepository;
import com.marcusvynicius.appoinment_management.dto.UpdateAppointmentDTO;
import com.marcusvynicius.appoinment_management.exceptions.AppointmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentEntity execute(UUID id, UpdateAppointmentDTO updateAppointmentDTO) {

        var appointment = this.appointmentRepository.findById(id).orElseThrow(() -> {
            throw new AppointmentNotFoundException();
        });

        appointment.setName(updateAppointmentDTO.getName());
        appointment.setCategory(updateAppointmentDTO.getCategory());
        appointment.setProfessional(updateAppointmentDTO.getProfessional());

        return this.appointmentRepository.save(appointment);
    }
}
