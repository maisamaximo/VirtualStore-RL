package payment;

public class PaymentStrategyCreditCard extends PaymentForm {

    private String creditCardNumber;
    private int installmentsTimes;

    public double getInstallmentsValue(double totalValueOrder, int installmentsTimes) {
        return totalValueOrder / installmentsTimes;
    }

    public String getCreditCardNumber(String creditCardNumber) {
        return this.creditCardNumber;
    }

    public int getInstallmentsTimes(int installmentsTimes) {
        return this.installmentsTimes;
    }
}
