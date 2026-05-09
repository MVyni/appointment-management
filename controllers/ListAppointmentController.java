package com.marcusvynicius.appoinment_management.controllers;

import com.marcusvynicius.appoinment_management.services.ListAppointmentByFilterService;
import com.marcusvynicius.appoinment_management.services.ListAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class ListAppointmentController {

    @Autowired
    private ListAppointmentService listAppointmentService;

    @Autowired
    private ListAppointmentByFilterService listAppointmentByFilterService;

    @GetMapping("/")
    public ResponseEntity<Object> list() {

        try {

            var result = this.listAppointmentService.execute();
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Object> listByNameAndCategory(
            @RequestParam String name,
            @RequestParam String category) {

        try {

            var result = this.listAppointmentByFilterService.execute(name, category);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
