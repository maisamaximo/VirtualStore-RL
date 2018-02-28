package main;


import data.Item;
import payment.PaymentType;

import java.time.LocalDateTime;
import java.util.*;

public class Order {

    private LocalDateTime orderDate;
    private final List<Item> itens;
    private PaymentType paymentType;
    //private ShoppingCart shoppingCart; deve receber carrinho de compra? getTotal duplicado aqui e no carrinho de compras

    public Order(List<Item> itens, PaymentType paymentType) {
        this.itens = new ArrayList<>(itens);
        this.orderDate  = LocalDateTime.now();
        this.paymentType = paymentType;
    }

    public double getTotal() {
        return itens.stream().mapToDouble(Item::getSubtotal).sum();
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
