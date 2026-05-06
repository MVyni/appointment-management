package com.marcusvynicius.appoinment_management.services;

import com.marcusvynicius.appoinment_management.AppointmentEntity;
import com.marcusvynicius.appoinment_management.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentEntity execute(AppointmentEntity appointmentEntity) {

        return this.appointmentRepository.save(appointmentEntity);
    }
}
