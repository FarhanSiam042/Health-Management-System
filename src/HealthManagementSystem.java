import java.util.ArrayList;
import java.util.List;

public class HealthManagementSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    public HealthManagementSystem() {
        // Load data from files
        this.patients = FileHelper.loadPatientsFromFile("patients.csv");
        this.doctors = FileHelper.loadDoctorsFromFile("doctors.csv");
        this.appointments = FileHelper.loadAppointmentsFromFile("appointments.csv");

        if (this.patients == null) this.patients = new ArrayList<>();
        if (this.doctors == null) this.doctors = new ArrayList<>();
        if (this.appointments == null) this.appointments = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        FileHelper.savePatientsToFile(patients, "patients.csv");
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        FileHelper.saveDoctorsToFile(doctors, "doctors.csv");
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        FileHelper.saveAppointmentsToFile(appointments, "appointments.csv");
    }

    public void showPatients() {
        for (Patient patient : patients) {
            System.out.println(patient.getDetails());
        }
    }

    public void showDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getDetails());
        }
    }

    public void showAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getDetails());
        }
    }

    public List<Doctor> getDoctorsBySpecialty(String specialty) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialty().equalsIgnoreCase(specialty)) {
                result.add(doctor);
            }
        }
        return result;
    }

    // Other getter methods
    public List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
