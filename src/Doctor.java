import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person implements Serializable {
    private String specialty;
    private List<Appointment> appointments;

    // No-argument constructor
    public Doctor() {
        super("Unknown", 0, "Unknown");
        this.specialty = "Unknown";
        this.appointments = new ArrayList<>();
    }

    // Constructor with parameters
    public Doctor(String name, int age, String gender, String specialty) {
        super(name, age, gender);
        this.specialty = specialty;
        this.appointments = new ArrayList<>();
    }

    // Getter for specialty
    public String getSpecialty() {
        return specialty;
    }

    // Getter for appointments
    public List<Appointment> getAppointments() {
        return appointments;
    }

    // Method to add an appointment to this doctor's list
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public String getDetails() {
        return "Doctor Name: " + getName() + ", Age: " + getAge() + ", Gender: " + getGender() + ", Specialty: " + specialty;
    }
}
