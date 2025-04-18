import java.io.Serializable;

public class Prescription implements Serializable {

    private String medicationName;
    private String dosage;
    private String instructions;

    public Prescription() {
        this.medicationName = "Unknown";
        this.dosage = "Unknown";
        this.instructions = "No instructions";
    }

    public Prescription(String medicationName, String dosage, String instructions) {
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.instructions = instructions;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    // Method to display prescription details
    public String getDetails() {
        return "Medication: " + medicationName + ", Dosage: " + dosage + ", Instructions: " + instructions;
    }
}
