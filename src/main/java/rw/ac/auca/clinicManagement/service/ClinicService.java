package rw.ac.auca.clinicManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.clinicManagement.entity.Clinic;
import rw.ac.auca.clinicManagement.repository.ClinicRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    @Autowired
    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public Clinic save(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public List<Clinic> findAll() {
        return clinicRepository.findAll();
    }

    public Optional<Clinic> findById(UUID id) {
        return clinicRepository.findById(id);
    }

    public Optional<Clinic> findByName(String name) {
        return clinicRepository.findByName(name);
    }

    public void deleteById(UUID id) {
        clinicRepository.deleteById(id);
    }
}
