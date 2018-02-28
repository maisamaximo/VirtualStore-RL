package payment;

public enum PaymentType {
    BILLET(1),
    CREDITCARD(2);

    private int optionPayment;

    PaymentType(int optionPayment){
        this.optionPayment = optionPayment;
    }

    public int getOptionPayment() {
        return optionPayment;
    }


}
