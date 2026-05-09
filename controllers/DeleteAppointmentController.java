package com.marcusvynicius.appoinment_management.controllers;

import com.marcusvynicius.appoinment_management.services.DeleteAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Controller
@RestController
@RequestMapping("/appointment")
public class DeleteAppointmentController {

    @Autowired
    private DeleteAppointmentService deleteAppointmentService;

    @DeleteMapping("/{id}")
     public ResponseEntity<Object> delete(@PathVariable UUID id) {

         try{
            this.deleteAppointmentService.execute(java.util.UUID.fromString(id.toString()));
            return ResponseEntity.ok().body("Appointment deleted successfully.");

         } catch (Exception e) {
             return ResponseEntity.badRequest().body(e.getMessage());
         }
     }
}
