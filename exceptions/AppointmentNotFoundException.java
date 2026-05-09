package com.marcusvynicius.appoinment_management.exceptions;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException()
    {
        super("Appointment not found");
    }
}
