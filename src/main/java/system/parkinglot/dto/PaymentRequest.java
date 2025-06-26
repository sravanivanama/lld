package system.parkinglot.dto;

public class PaymentRequest {
    String upiId;
    String name;
    String cardNumber;
    int monthOfExpiry;
    int yearOfExpiry;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    int ticketId;
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    String paymentType;

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getMonthOfExpiry() {
        return monthOfExpiry;
    }

    public void setMonthOfExpiry(int monthOfExpiry) {
        this.monthOfExpiry = monthOfExpiry;
    }

    public int getYearOfExpiry() {
        return yearOfExpiry;
    }

    public void setYearOfExpiry(int yearOfExpiry) {
        this.yearOfExpiry = yearOfExpiry;
    }
}
