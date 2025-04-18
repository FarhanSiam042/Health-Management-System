import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileHelper {

    // Write patients data to a CSV file
    public static void savePatientsToFile(List<Patient> patients, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Patient patient : patients) {
                writer.write(patient.getName() + "," + patient.getAge() + "," + patient.getGender() + "," + patient.getMedicalHistory());
                writer.newLine();
            }
            System.out.println("Patient data saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving patient data: " + e.getMessage());
        }
    }

    // Read patients data from a CSV file
    public static List<Patient> loadPatientsFromFile(String filename) {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                int age = Integer.parseInt(fields[1]);
                String gender = fields[2];
                String medicalHistory = fields[3];
                patients.add(new Patient(name, age, gender, medicalHistory));
            }
            System.out.println("Patient data loaded successfully from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading patient data: " + e.getMessage());
        }
        return patients;
    }

    // Write doctor data to a CSV file
    public static void saveDoctorsToFile(List<Doctor> doctors, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.getName() + "," + doctor.getAge() + "," + doctor.getGender() + "," + doctor.getSpecialty());
                writer.newLine();
            }
            System.out.println("Doctor data saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving doctor data: " + e.getMessage());
        }
    }

    // Read doctor data from a CSV file
    public static List<Doctor> loadDoctorsFromFile(String filename) {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                int age = Integer.parseInt(fields[1]);
                String gender = fields[2];
                String specialty = fields[3];
                doctors.add(new Doctor(name, age, gender, specialty));
            }
            System.out.println("Doctor data loaded successfully from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading doctor data: " + e.getMessage());
        }
        return doctors;
    }

    // Write appointment data to a CSV file
    public static void saveAppointmentsToFile(List<Appointment> appointments, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.getPatient().getName() + "," +
                        appointment.getDoctor().getName() + "," +
                        appointment.getDate() + "," +
                        appointment.getTime());
                writer.newLine();
            }
            System.out.println("Appointment data saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving appointment data: " + e.getMessage());
        }
    }

    // Read appointment data from a CSV file
    public static List<Appointment> loadAppointmentsFromFile(String filename) {
        List<Appointment> appointments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String patientName = fields[0];
                String doctorName = fields[1];
                String date = fields[2];  // In real use, this should be parsed into a LocalDate
                String time = fields[3];

                // You would need to look up the patient and doctor by name, for simplicity we'll assume they're already loaded
                Patient patient = new Patient(patientName, 0, "Unknown", "N/A");
                Doctor doctor = new Doctor(doctorName, 0, "Unknown", "N/A");
                appointments.add(new Appointment(patient, doctor, LocalDate.parse(date), time));
            }
            System.out.println("Appointment data loaded successfully from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading appointment data: " + e.getMessage());
        }
        return appointments;
    }
}
