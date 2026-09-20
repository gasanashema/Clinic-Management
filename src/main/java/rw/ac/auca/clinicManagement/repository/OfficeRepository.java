package rw.ac.auca.clinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.auca.clinicManagement.entity.Office;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfficeRepository extends JpaRepository<Office, UUID> {
    Optional<Office> findByRoomNumber(String roomNumber);
    Optional<Office> findByDoctorId(UUID doctorId);
    boolean existsByRoomNumber(String roomNumber);
}
