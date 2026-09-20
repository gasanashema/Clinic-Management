# Clinic Management System

A Spring Boot application developed to model a clinic and demonstrate JPA entity relationships.

## Project Overview

This project models a clinic domain to illustrate Object-Relational Mapping (ORM) and entity relationships using Jakarta Persistence (JPA).

Key domain rules:
- A clinic has doctors and patients.
- Patients book appointments with doctors.
- Appointments have a date, reason, and status.
- Each doctor has exactly one office.
- Doctors can have multiple specializations.
- A specialization can belong to multiple doctors.
- The many-to-many relationship between Doctor and Specialization is modeled through `DoctorSpecialization`.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok

## Entity Model

- **Clinic**: Represents a healthcare facility that contains doctors and patients.
- **Doctor**: Represents a medical professional working at a clinic, assigned an office, and possessing specializations.
- **Patient**: Represents an individual registered at a clinic who books appointments.
- **Appointment**: Represents a consultation between a patient and a doctor, including a date, reason, and status (`AppointmentStatus`).
- **Office**: Represents a physical room assigned exclusively to one doctor.
- **Specialization**: Represents a field of medical practice (e.g., Cardiology, Pediatrics).
- **DoctorSpecialization**: Represents the junction entity managing the many-to-many relationship between doctors and specializations using a composite primary key.

## Entity Relationships

| Relationship | Type | Foreign Key | Location |
| :--- | :--- | :--- | :--- |
| **Clinic -> Doctor** | 1:N | `clinic_id` | `doctor` table |
| **Clinic -> Patient** | 1:N | `clinic_id` | `patient` table |
| **Patient -> Appointment** | 1:N | `patient_id` | `appointment` table |
| **Doctor -> Appointment** | 1:N | `doctor_id` | `appointment` table |
| **Doctor -> Office** | 1:1 | `doctor_id` | `office` table (UNIQUE) |
| **Doctor -> Specialization** | N:N | `doctor_id`, `specialization_id` | `doctor_specialization` table |

### Modeling Rationale

- **Appointment as an Entity**: An appointment contains distinct attributes beyond the patient and doctor references, such as appointment date, reason, and status (`AppointmentStatus`). Modeling it as an explicit entity allows for state tracking and independent query capability.
- **Explicit DoctorSpecialization Entity**: Instead of using a direct `@ManyToMany` annotation, `DoctorSpecialization` is explicitly defined to promote the junction table to an entity using `@EmbeddedId` and `@MapsId`. This follows clean domain modeling practices and permits adding extra attributes to the relationship in the future.

## Database Structure

The project relies on Hibernate schema generation (`spring.jpa.hibernate.ddl-auto=update`) to generate database tables:

- **clinic**
  - `id` (PK)
  - `name`
- **doctor**
  - `id` (PK)
  - `name`, `email`, `phone`
  - `clinic_id` (FK referencing `clinic.id`)
- **patient**
  - `id` (PK)
  - `name`, `email`, `phone`
  - `clinic_id` (FK referencing `clinic.id`)
- **appointment**
  - `id` (PK)
  - `date`, `reason`, `status`
  - `patient_id` (FK referencing `patient.id`)
  - `doctor_id` (FK referencing `doctor.id`)
- **office**
  - `id` (PK)
  - `room_number`
  - `doctor_id` (FK referencing `doctor.id`, UNIQUE)
- **specialization**
  - `id` (PK)
  - `name`
- **doctor_specialization**
  - `doctor_id` (PK, FK referencing `doctor.id`)
  - `specialization_id` (PK, FK referencing `specialization.id`)

## Project Structure

```text
src/
└── main/
    ├── java/
    │   └── rw/
    │       └── ac/
    │           └── auca/
    │               └── clinicManagement/
    │                   ├── ClinicManagementApplication.java
    │                   └── entity/
    │                       ├── Appointment.java
    │                       ├── AppointmentStatus.java
    │                       ├── Clinic.java
    │                       ├── Doctor.java
    │                       ├── DoctorSpecialization.java
    │                       ├── DoctorSpecializationId.java
    │                       ├── Office.java
    │                       ├── Patient.java
    │                       └── Specialization.java
    └── resources/
        └── application.properties
```
