class Prescription {
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

    // Getters
    public String getMedicationName() {
        return medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    // Display prescription details
    public String getDetails() {
        return "Medication: " + medicationName + ", Dosage: " + dosage + ", Instructions: " + instructions;
    }
}
