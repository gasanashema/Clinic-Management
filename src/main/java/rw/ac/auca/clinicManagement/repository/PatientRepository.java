package rw.ac.auca.clinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.auca.clinicManagement.entity.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    List<Patient> findByClinicId(UUID clinicId);
    Optional<Patient> findByEmail(String email);
}
