package rw.ac.auca.clinicManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.clinicManagement.entity.Specialization;
import rw.ac.auca.clinicManagement.repository.SpecializationRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpecializationService {

    private final SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public Specialization save(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    public Optional<Specialization> findById(UUID id) {
        return specializationRepository.findById(id);
    }

    public Optional<Specialization> findByName(String name) {
        return specializationRepository.findByName(name);
    }

    public void deleteById(UUID id) {
        specializationRepository.deleteById(id);
    }
}
