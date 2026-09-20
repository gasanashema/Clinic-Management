package rw.ac.auca.clinicManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.clinicManagement.entity.Patient;
import rw.ac.auca.clinicManagement.repository.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(UUID id) {
        return patientRepository.findById(id);
    }

    public List<Patient> findByClinicId(UUID clinicId) {
        return patientRepository.findByClinicId(clinicId);
    }

    public Optional<Patient> findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public void deleteById(UUID id) {
        patientRepository.deleteById(id);
    }
}
