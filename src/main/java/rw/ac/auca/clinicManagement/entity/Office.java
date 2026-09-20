package rw.ac.auca.clinicManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "office")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @OneToOne
    @JoinColumn(name = "doctor_id", nullable = false, unique = true)
    private Doctor doctor;
}
