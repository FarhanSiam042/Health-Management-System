import java.io.Serializable;
import java.time.LocalDate;

class Payment implements Serializable {
    private double amount;
    private String paymentMethod;  // e.g., "Credit Card", "Cash", "Insurance"
    private String status;         // e.g., "Pending", "Completed"
    private String serviceDescription;  // Description of the service
    private LocalDate paymentDate;  // Date when payment was made

    public Payment() {
        this.amount = 0.0;
        this.paymentMethod = "Unknown";
        this.status = "Pending";
        this.serviceDescription = "Unknown Service";
        this.paymentDate = LocalDate.now();  // Default to today's date
    }

    // Constructor
    public Payment(double amount, String paymentMethod, String serviceDescription) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = "Pending";  // By default, payment status is pending
        this.serviceDescription = serviceDescription;
        this.paymentDate = LocalDate.now();  // Set the payment date to today's date
    }

    // Complete the payment (Change status to 'Completed')
    public void completePayment() {
        this.status = "Completed";
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    // Display payment details
    public String getDetails() {
        return "Payment Amount: $" + amount +
                ", Method: " + paymentMethod +
                ", Status: " + status +
                ", Service: " + serviceDescription +
                ", Date: " + paymentDate;
    }
}

