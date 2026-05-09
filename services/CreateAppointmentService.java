package com.marcusvynicius.appoinment_management.services;

import com.marcusvynicius.appoinment_management.AppointmentEntity;
import com.marcusvynicius.appoinment_management.AppointmentRepository;
import com.marcusvynicius.appoinment_management.dto.CreateAppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentEntity execute(CreateAppointmentDTO createAppointmentDTO) {

        var appointmentEntity = AppointmentEntity.builder()
                .name(createAppointmentDTO.getName())
                .category(createAppointmentDTO.getCategory())
                .professional(createAppointmentDTO.getProfessional())
                .build();

        return this.appointmentRepository.save(appointmentEntity);
    }
}
