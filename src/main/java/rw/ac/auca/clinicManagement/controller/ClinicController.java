package rw.ac.auca.clinicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.auca.clinicManagement.entity.Clinic;
import rw.ac.auca.clinicManagement.service.ClinicService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clinic")
public class ClinicController {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping("/save")
    public ResponseEntity<Clinic> saveClinic(@RequestBody Clinic clinic) {
        Clinic savedClinic = clinicService.save(clinic);
        return new ResponseEntity<>(savedClinic, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Clinic>> getAllClinics() {
        return ResponseEntity.ok(clinicService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable UUID id) {
        return clinicService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinic(@PathVariable UUID id) {
        clinicService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
