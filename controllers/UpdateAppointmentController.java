package com.marcusvynicius.appoinment_management.controllers;

import com.marcusvynicius.appoinment_management.AppointmentEntity;
import com.marcusvynicius.appoinment_management.dto.PatchActiveDTO;
import com.marcusvynicius.appoinment_management.dto.UpdateAppointmentDTO;
import com.marcusvynicius.appoinment_management.services.PatchActiveAppointmentService;
import com.marcusvynicius.appoinment_management.services.UpdateAppointmentService;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RestController
@RequestMapping("/appointment")
public class UpdateAppointmentController {

    @Autowired
    private UpdateAppointmentService updateAppointmentService;

    @Autowired
    private PatchActiveAppointmentService patchActiveAppointmentService;

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable("id") UUID id,
            @Valid @RequestBody UpdateAppointmentDTO updateAppointmentDTO) {


        try {
            var result = this.updateAppointmentService.execute(id, updateAppointmentDTO);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
     }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> patchActive(
            @PathVariable("id") UUID id,
            @RequestBody PatchActiveDTO patchActiveDTO) {

        try {
            var result = this.patchActiveAppointmentService.execute(id, patchActiveDTO);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
     }
}
