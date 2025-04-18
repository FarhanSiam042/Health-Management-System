import java.io.Serializable;
import java.time.LocalDate;

public class Payment implements Serializable {


    private double amount;
    private String paymentMethod;  // e.g., "Credit Card", "Cash", "Insurance"
    private String status;         // e.g., "Pending", "Completed"
    private LocalDate paymentDate;  // Date when payment was made
    private String serviceDescription;  // Description of the service
    private String doctorName;


    public Payment() {
        this.amount = 0.0;
        this.paymentMethod = "Unknown";
        this.status = "Pending";
        this.paymentDate = LocalDate.now();  // Default to today's date
        this.serviceDescription = "Unknown Service";
        this.doctorName = "Unknown";
    }

    // Constructor with parameters
    public Payment(double amount, String paymentMethod, String serviceDescription, String doctorName) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = "Pending";  // By default, payment status is pending
        this.paymentDate = LocalDate.now();  // Set the payment date to today's date
        this.serviceDescription = serviceDescription;
        this.doctorName = doctorName;
    }

    // Getters for the payment details
    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    // Method to get the payment details as a String
    public String getDetails() {
        return "Amount: $" + amount +
                ", Method: " + paymentMethod +
                ", Status: " + status +
                ", Service: " + serviceDescription +
                ", Date: " + paymentDate+
                ", Doctor: " + doctorName;

    }
    public void markAsCompleted() {
        this.status = "Completed";
    }

}
