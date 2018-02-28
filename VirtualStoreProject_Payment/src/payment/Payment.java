package payment;

import view.ViewBillet;
import view.ViewCreditCard;
import view.ViewPaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class Payment {

    //alterar o segundo map pra paymentType
    private Map<Integer, ViewPaymentStrategy> map = new HashMap<>();
    private PaymentType paymentType;

    public Payment(){
        map.put(paymentType.BILLET.getOptionPayment(), new ViewBillet());
        map.put(paymentType.CREDITCARD.getOptionPayment(), new ViewCreditCard());
    }

    public ViewPaymentStrategy paymentExecute(int paymentOption){
        return map.get(paymentOption);
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Map<Integer, ViewPaymentStrategy> getMap() {
        return map;
    }
}

