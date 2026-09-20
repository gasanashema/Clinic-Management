package rw.ac.auca.clinicManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "doctor_specialization")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSpecialization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "specialization_id", nullable = false)
    private Specialization specialization;

    public DoctorSpecialization(Doctor doctor, Specialization specialization) {
        this.doctor = doctor;
        this.specialization = specialization;
    }
}
