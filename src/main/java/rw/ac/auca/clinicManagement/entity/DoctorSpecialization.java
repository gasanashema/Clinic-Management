package rw.ac.auca.clinicManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor_specialization")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSpecialization {

    @EmbeddedId
    private DoctorSpecializationId id;

    @ManyToOne
    @MapsId("doctorId")
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @MapsId("specializationId")
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    public DoctorSpecialization(Doctor doctor, Specialization specialization) {
        this.doctor = doctor;
        this.specialization = specialization;
        this.id = new DoctorSpecializationId(
            doctor != null ? doctor.getId() : null,
            specialization != null ? specialization.getId() : null
        );
    }
}
