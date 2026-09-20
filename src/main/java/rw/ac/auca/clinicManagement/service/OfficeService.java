package rw.ac.auca.clinicManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.clinicManagement.entity.Doctor;
import rw.ac.auca.clinicManagement.entity.Office;
import rw.ac.auca.clinicManagement.repository.DoctorRepository;
import rw.ac.auca.clinicManagement.repository.OfficeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository, DoctorRepository doctorRepository) {
        this.officeRepository = officeRepository;
        this.doctorRepository = doctorRepository;
    }

    public Office save(Office office) {
        return officeRepository.save(office);
    }

    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    public Optional<Office> findById(UUID id) {
        return officeRepository.findById(id);
    }

    public Optional<Office> findByRoomNumber(String roomNumber) {
        return officeRepository.findByRoomNumber(roomNumber);
    }

    public void deleteById(UUID id) {
        officeRepository.deleteById(id);
    }

    public Office assignDoctorToOffice(UUID officeId, UUID doctorId) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new IllegalArgumentException("Office not found with id: " + officeId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found with id: " + doctorId));

        office.setDoctor(doctor);
        return officeRepository.save(office);
    }
}
