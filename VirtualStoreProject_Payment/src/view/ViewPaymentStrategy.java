package view;

import main.Order;

public interface ViewPaymentStrategy {

    void executeView(Order order);
}
