import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person implements Serializable {
    private static final long serialVersionUID = 5079818788762436159L;
    private String medicalHistory;
    private List<Prescription> prescriptions;
    private List<Payment> payments;  // Track payments for this patient


    public Patient() {
        super("Unknown", 0, "Unknown");

        this.medicalHistory = "No medical history";  // Default value
        this.prescriptions = new ArrayList<>();
        this.payments = new ArrayList<>();
    }
    // Constructor that takes all the fields
    public Patient(String name, int age, String gender, String medicalHistory) {
        super(name, age, gender);
        this.medicalHistory = medicalHistory;
        this.prescriptions = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    // Getter for medical history
    public String getMedicalHistory() {
        return medicalHistory;
    }

    // Add a prescription
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Add a payment
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    // Show details
    @Override
    public String getDetails() {
        return "Patient Name: " + getName() + ", Age: " + getAge() + ", Gender: " + getGender() + ", Medical History: " + medicalHistory;
    }

    // Show all payments
    public void showPayments() {
        if (payments.isEmpty()) {
            System.out.println("No payments recorded.");
        } else {
            for (Payment payment : payments) {
                System.out.println(payment.getDetails());
            }
        }
    }

    // Get all prescriptions
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }
    public void showPrescriptions() {
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions recorded.");
        } else {
            for (Prescription prescription : prescriptions) {
                System.out.println(prescription.getDetails());
            }
        }
    }
}
