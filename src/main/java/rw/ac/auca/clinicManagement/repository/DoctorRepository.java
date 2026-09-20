package rw.ac.auca.clinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.auca.clinicManagement.entity.Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    List<Doctor> findByClinicId(UUID clinicId);
    Optional<Doctor> findByEmail(String email);
}
