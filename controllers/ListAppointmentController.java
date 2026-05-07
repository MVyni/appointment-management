package com.marcusvynicius.appoinment_management.controllers;

import com.marcusvynicius.appoinment_management.services.ListAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class ListAppointmentController {

    @Autowired
    private ListAppointmentService listAppointmentService;

    @GetMapping("/")
    public ResponseEntity<Object> list() {

        try {

            var result = this.listAppointmentService.execute();
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
