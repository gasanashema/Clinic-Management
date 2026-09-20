package rw.ac.auca.clinicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.auca.clinicManagement.entity.Office;
import rw.ac.auca.clinicManagement.service.OfficeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Office> saveOffice(@RequestBody Office office) {
        Office savedOffice = officeService.save(office);
        return new ResponseEntity<>(savedOffice, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Office>> getAllOffices() {
        return ResponseEntity.ok(officeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Office> getOfficeById(@PathVariable UUID id) {
        return officeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffice(@PathVariable UUID id) {
        officeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
