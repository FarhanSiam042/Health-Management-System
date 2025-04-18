import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class HealthManagementSystemUI {

    private static Scanner scanner = new Scanner(System.in);
    private static HealthManagementSystem system = new HealthManagementSystem();

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            int choice = getUserInput();
            handleMainMenuChoice(choice);
        }
    }

    // Color codes
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String MAGENTA = "\u001B[35m";

    private static void showMainMenu() {
        System.out.println(CYAN + "\n===================================" + RESET);
        System.out.println(BLUE + "HealGO : The Health Management System - Main Menu" + RESET);
        System.out.println(CYAN + "===================================" + RESET);
        System.out.println(GREEN + "1. Manage Patients" + RESET);
        System.out.println(GREEN + "2. Manage Doctors" + RESET);
        System.out.println(GREEN + "3. Manage Appointments" + RESET);
        System.out.println(GREEN + "4. Manage Prescription" + RESET);  // Option 4
        System.out.println(GREEN + "5. Manage Payments" + RESET);
        System.out.println(YELLOW + "4. Exit" + RESET);
        System.out.print(BLUE + "Enter your choice: " + RESET);
    }

    private static int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println(RED + "Invalid input. Please enter a valid number." + RESET);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void handleMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                managePatients();
                break;
            case 2:
                manageDoctors();
                break;
            case 3:
                manageAppointments();
                break;
            case 4:
                managePrescriptions();  // Manage Prescriptions (Option 4)
                break;
            case 5:
                managePayments();  // Manage Payments (Option 5)
                break;
            case 6:
                System.out.println(YELLOW + "Exiting system..." + RESET);
                System.exit(0);
                break;
            default:
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
        }
    }

    // Manage Patients
    private static void managePatients() {
        while (true) {
            System.out.println("\n" + CYAN + "Patient Menu" + RESET);
            System.out.println(GREEN + "1. Add New Patient" + RESET);
            System.out.println(GREEN + "2. View All Patients" + RESET);
            System.out.println(GREEN + "3. View Patient Medical History" + RESET);
            System.out.println(YELLOW + "4. Back to Main Menu" + RESET);
            System.out.print(BLUE + "Enter your choice: " + RESET);

            int choice = getUserInput();
            switch (choice) {
                case 1:
                    addNewPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    viewPatientMedicalHistory();
                    break;
                case 4:
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        }
    }

    private static void addNewPatient() {
        scanner.nextLine();  // consume newline
        System.out.print(GREEN + "Enter patient's name: " + RESET);
        String name = scanner.nextLine();
        System.out.print(GREEN + "Enter patient's age: " + RESET);
        int age = getUserInput();
        System.out.print(GREEN + "Enter patient's gender: " + RESET);
        String gender = scanner.next();
        System.out.print(GREEN + "Enter patient's medical history: " + RESET);
        scanner.nextLine();  // consume newline
        String medicalHistory = scanner.nextLine();

        Patient newPatient = new Patient(name, age, gender, medicalHistory);
        system.addPatient(newPatient); // Adds the patient and saves data to file
        System.out.println(GREEN + "Patient added successfully." + RESET);
    }

    private static void viewAllPatients() {
        System.out.println("\n" + CYAN + "Patient List:" + RESET);
        system.showPatients();
    }

    private static void viewPatientMedicalHistory() {
        scanner.nextLine();  // consume newline
        System.out.print(GREEN + "Enter patient's name: " + RESET);
        String name = scanner.nextLine();
        for (Patient patient : system.getPatients()) {
            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println(CYAN + "Medical History for " + patient.getName() + ": " + RESET + patient.getMedicalHistory());
                return;
            }
        }
        System.out.println(RED + "Patient not found." + RESET);
    }

    // Manage Doctors
    private static void manageDoctors() {
        while (true) {
            System.out.println("\n" + CYAN + "Doctor Menu" + RESET);
            System.out.println(GREEN + "1. Add a New Doctor" + RESET);
            System.out.println(GREEN + "2. View All Doctors" + RESET);
            System.out.println(GREEN + "3. Search Doctors by Specialty" + RESET);
            System.out.println(YELLOW + "4. Back to Main Menu" + RESET);
            System.out.print(BLUE + "Enter your choice: " + RESET);

            int choice = getUserInput();
            switch (choice) {
                case 1:
                    addNewDoctor();
                    break;
                case 2:
                    viewAllDoctors();
                    break;
                case 3:
                    searchDoctorsBySpecialty();
                    break;
                case 4:
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        }
    }

    private static void addNewDoctor() {
        scanner.nextLine();  // consume newline
        System.out.print(GREEN + "Enter doctor's name: " + RESET);
        String name = scanner.nextLine();
        System.out.print(GREEN + "Enter doctor's age: " + RESET);
        int age = getUserInput();
        System.out.print(GREEN + "Enter doctor's gender: " + RESET);
        String gender = scanner.next();
        System.out.print(GREEN + "Enter doctor's specialty: " + RESET);
        String specialty = scanner.next();

        Doctor newDoctor = new Doctor(name, age, gender, specialty);
        system.addDoctor(newDoctor); // Adds the doctor and saves data to file
        System.out.println(GREEN + "Doctor added successfully." + RESET);
    }

    private static void viewAllDoctors() {
        System.out.println("\n" + CYAN + "Doctor List:" + RESET);
        system.showDoctors();
    }

    private static void searchDoctorsBySpecialty() {
        scanner.nextLine();  // consume newline
        System.out.print(GREEN + "Enter doctor's specialty to search: " + RESET);
        String specialty = scanner.nextLine();

        List<Doctor> doctors = system.getDoctorsBySpecialty(specialty);
        if (doctors.isEmpty()) {
            System.out.println(RED + "No doctors found with the specialty " + specialty + "." + RESET);
        } else {
            System.out.println("\nDoctors with specialty " + specialty + ":");
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getDetails());
            }
        }
    }


    private static void manageAppointments() {
        while (true) {
            System.out.println("\n" + CYAN + "Appointment Menu" + RESET);
            System.out.println(GREEN + "1. Schedule an Appointment" + RESET);
            System.out.println(GREEN + "2. View All Appointments" + RESET);
            System.out.println(YELLOW + "3. Back to Main Menu" + RESET);
            System.out.print(BLUE + "Enter your choice: " + RESET);

            int choice = getUserInput();
            switch (choice) {
                case 1:
                    scheduleAppointment();
                    break;
                case 2:
                    viewAllAppointments();
                    break;
                case 3:
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        }
    }

    private static void scheduleAppointment() {
        scanner.nextLine();  // consume newline
        System.out.print(GREEN + "Enter patient's name: " + RESET);
        String patientName = scanner.nextLine();
        System.out.print(GREEN + "Enter doctor's name: " + RESET);
        String doctorName = scanner.nextLine();
        System.out.print(GREEN + "Enter appointment date (YYYY-MM-DD): " + RESET);
        String date = scanner.nextLine();
        System.out.print(GREEN + "Enter appointment time: " + RESET);
        String time = scanner.nextLine();


        Patient patient = null;
        Doctor doctor = null;

        for (Patient p : system.getPatients()) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                patient = p;
                break;
            }
        }

        for (Doctor d : system.getDoctors()) {
            if (d.getName().equalsIgnoreCase(doctorName)) {
                doctor = d;
                break;
            }
        }

        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(patient, doctor, LocalDate.parse(date), time);
            system.addAppointment(appointment);
            doctor.addAppointment(appointment);
            System.out.println(GREEN + "Appointment scheduled successfully." + RESET);
        } else {
            System.out.println(RED + "Invalid patient or doctor name." + RESET);
        }
    }

    private static void viewAllAppointments() {
        System.out.println("\n" + CYAN + "Appointment List:" + RESET);
        system.showAppointments();
    }

    private static void managePrescriptions() {
        while (true) {
            System.out.println("\n" + CYAN + "Prescription Menu" + RESET);
            System.out.println(GREEN + "1. Add a Prescription for Patient" + RESET);
            System.out.println(GREEN + "2. View Prescriptions for Patient" + RESET);  // Option to view prescriptions
            System.out.println(YELLOW + "3. Back to Main Menu" + RESET);
            System.out.print(BLUE + "Enter your choice: " + RESET);

            int choice = getUserInput();
            switch (choice) {
                case 1:
                    addPrescription();  // Call the method to add a prescription
                    break;
                case 2:
                    viewPrescriptionsForPatient();  // Call the method to view prescriptions for a specific patient
                    break;
                case 3:
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        }
    }

    private static void addPrescription() {
        scanner.nextLine();  // Consume newline character
        System.out.print(GREEN + "Enter patient's name: " + RESET);
        String patientName = scanner.nextLine();

        // Find patient by name
        Patient patient = null;
        for (Patient p : system.getPatients()) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            System.out.println(RED + "Patient not found." + RESET);
            return;
        }

        // Get prescription details
        System.out.print(GREEN + "Enter medication name: " + RESET);
        String medicationName = scanner.nextLine();
        System.out.print(GREEN + "Enter dosage: " + RESET);
        String dosage = scanner.nextLine();
        System.out.print(GREEN + "Enter instructions: " + RESET);
        String instructions = scanner.nextLine();

        // Create and add prescription
        Prescription prescription = new Prescription(medicationName, dosage, instructions);
        patient.addPrescription(prescription);

        System.out.println(GREEN + "Prescription added successfully." + RESET);
    }


    private static void managePayments() {
        while (true) {
            System.out.println("\n" + CYAN + "Payment Menu" + RESET);
            System.out.println(GREEN + "1. Add a Payment for Patient" + RESET);
            System.out.println(GREEN + "2. View Payments for Patient" + RESET);  // Option to view payments
            System.out.println(YELLOW + "3. Back to Main Menu" + RESET);
            System.out.print(BLUE + "Enter your choice: " + RESET);

            int choice = getUserInput();
            switch (choice) {
                case 1:
                    addPayment();  // Call the method to add a payment
                    break;
                case 2:
                    viewPaymentsForPatient();  // Call the method to view payments for a specific patient
                    break;
                case 3:
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        }
    }


    private static void viewPrescriptionsForPatient() {
        scanner.nextLine();  // Consume newline character
        System.out.print(GREEN + "Enter patient's name to view prescriptions: " + RESET);
        String patientName = scanner.nextLine();

        // Find patient by name
        Patient patient = null;
        for (Patient p : system.getPatients()) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            System.out.println(RED + "Patient not found." + RESET);
            return;
        }

        System.out.println(CYAN + "Prescriptions for " + patient.getName() + ":" + RESET);
        for (Prescription prescription : patient.getPrescriptions()) {
            System.out.println(prescription.getDetails());
        }
    }
    private static void addPayment() {
        scanner.nextLine();  // Consume newline character
        System.out.print(GREEN + "Enter patient's name: " + RESET);
        String patientName = scanner.nextLine();

        // Find the patient by name
        Patient patient = null;
        for (Patient p : system.getPatients()) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            System.out.println(RED + "Patient not found." + RESET);
            return;
        }

        // Get payment details from the user
        System.out.print(GREEN + "Enter payment amount: " + RESET);
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        System.out.print(GREEN + "Enter payment method (e.g., Credit Card, Cash, Insurance): " + RESET);
        String paymentMethod = scanner.nextLine();
        System.out.print(GREEN + "Enter service description: " + RESET);
        String serviceDescription = scanner.nextLine();
        System.out.print(GREEN + "Enter the doctor's name who provided the service: " + RESET);
        String doctorName = scanner.nextLine();

        // Create a new payment and add it to the patient
        Payment payment = new Payment(amount, paymentMethod, serviceDescription, doctorName);
        payment.markAsCompleted();
        patient.addPayment(payment);

        System.out.println(GREEN + "Payment added successfully." + RESET);
    }


    private static void viewPaymentsForPatient() {
        scanner.nextLine();  // Consume newline character
        System.out.print(GREEN + "Enter patient's name to view payments: " + RESET);
        String patientName = scanner.nextLine();

        // Find the patient by name
        Patient patient = null;
        for (Patient p : system.getPatients()) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            System.out.println(RED + "Patient not found." + RESET);
            return;
        }

        System.out.println(CYAN + "Payments for " + patient.getName() + ":" + RESET);
        patient.showPayments();
    }
}

