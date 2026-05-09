package com.marcusvynicius.appoinment_management.services;

import com.marcusvynicius.appoinment_management.AppointmentEntity;
import com.marcusvynicius.appoinment_management.AppointmentRepository;
import com.marcusvynicius.appoinment_management.exceptions.NameAndCategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAppointmentByFilterService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentEntity> execute(String name, String category) {

        var appointment = this.appointmentRepository.findByNameAndCategory(
                name, category);

        if(appointment.isEmpty()) {
            throw new NameAndCategoryNotFoundException();
        }

        return appointment;
    }
}
