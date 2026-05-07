package com.marcusvynicius.appoinment_management.services;

import com.marcusvynicius.appoinment_management.AppointmentEntity;
import com.marcusvynicius.appoinment_management.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentEntity> execute() {
        
        return this.appointmentRepository.findAll();
    }
}
