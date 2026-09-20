package rw.ac.auca.clinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.auca.clinicManagement.entity.DoctorSpecialization;

import java.util.List;
import java.util.UUID;

public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization, UUID> {
    List<DoctorSpecialization> findByDoctorId(UUID doctorId);
    List<DoctorSpecialization> findBySpecializationId(UUID specializationId);
}
