package rw.ac.auca.clinicManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.auca.clinicManagement.entity.Doctor;
import rw.ac.auca.clinicManagement.entity.DoctorSpecialization;
import rw.ac.auca.clinicManagement.entity.Specialization;
import rw.ac.auca.clinicManagement.repository.DoctorRepository;
import rw.ac.auca.clinicManagement.repository.DoctorSpecializationRepository;
import rw.ac.auca.clinicManagement.repository.SpecializationRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final SpecializationRepository specializationRepository;
    private final DoctorSpecializationRepository doctorSpecializationRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository,
                         SpecializationRepository specializationRepository,
                         DoctorSpecializationRepository doctorSpecializationRepository) {
        this.doctorRepository = doctorRepository;
        this.specializationRepository = specializationRepository;
        this.doctorSpecializationRepository = doctorSpecializationRepository;
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findById(UUID id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> findByClinicId(UUID clinicId) {
        return doctorRepository.findByClinicId(clinicId);
    }

    public void deleteById(UUID id) {
        doctorRepository.deleteById(id);
    }

    public DoctorSpecialization addSpecialization(UUID doctorId, UUID specializationId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found with id: " + doctorId));
        Specialization specialization = specializationRepository.findById(specializationId)
                .orElseThrow(() -> new IllegalArgumentException("Specialization not found with id: " + specializationId));

        DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor, specialization);
        return doctorSpecializationRepository.save(doctorSpecialization);
    }
}
