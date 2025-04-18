import java.io.Serializable;
import java.time.LocalDate;

public class Appointment implements Serializable {
    private static final long serialVersionUID = 123456789L;  // Add serialVersionUID
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String time;
    private String status;

    // No-argument constructor (required for deserialization)
    public Appointment() {
        this.patient = new Patient();  // Default patient object
        this.doctor = new Doctor();    // Default doctor object
        this.date = LocalDate.now();   // Default to today's date
        this.time = "Unknown";         // Default time
        this.status = "Scheduled";     // Default status
    }

    // Constructor with parameters
    public Appointment(Patient patient, Doctor doctor, LocalDate date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = "Scheduled";
    }

    // Getter methods for patient, doctor, date, and time
    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    // Method to get the appointment details as a String
    public String getDetails() {
        return "Appointment: " + patient.getName() + " with Dr. " + doctor.getName() + " on " + date + " at " + time + " (Status: " + status + ")";
    }
}
