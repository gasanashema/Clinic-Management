package rw.ac.auca.clinicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.auca.clinicManagement.entity.Appointment;
import rw.ac.auca.clinicManagement.entity.AppointmentStatus;
import rw.ac.auca.clinicManagement.service.AppointmentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
        Appointment saved = appointmentService.save(appointment);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestParam UUID patientId,
                                                        @RequestParam UUID doctorId,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                                        @RequestParam(required = false) String reason) {
        Appointment appointment = appointmentService.createAppointment(patientId, doctorId, date, reason);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable UUID id) {
        return appointmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Appointment> updateStatus(@PathVariable UUID id, @RequestParam AppointmentStatus status) {
        Appointment updated = appointmentService.updateStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable UUID id) {
        appointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
