package rw.ac.auca.clinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.auca.clinicManagement.entity.Specialization;

import java.util.Optional;
import java.util.UUID;

public interface SpecializationRepository extends JpaRepository<Specialization, UUID> {
    Optional<Specialization> findByName(String name);
}
