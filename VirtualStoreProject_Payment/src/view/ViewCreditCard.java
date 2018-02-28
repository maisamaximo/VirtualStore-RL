package view;

import data.Item;
import main.Order;
import payment.PaymentStrategyCreditCard;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class ViewCreditCard implements ViewPaymentStrategy {

    //solicitar dados do cartao é diferente de emitir nota fiscal final, apesar de receber informações de dado do cartao e parcelas

    private final PrintInformations printInformations = new PrintInformations();
    Scanner read = new Scanner(System.in);

    @Override
    public void executeView(Order order) {
        String informedCreditCardNumber;
        int informedInstallmentsTimes;

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
        PaymentStrategyCreditCard credit = new PaymentStrategyCreditCard();

        System.out.print("Enter with your Credit Card number: ");
        informedCreditCardNumber = read.next();
        System.out.print("How many installments? ");
        informedInstallmentsTimes = read.nextByte();

        //fazendo mais de uma coisa
        credit.getCreditCardNumber(informedCreditCardNumber);
        credit.getInstallmentsTimes(informedInstallmentsTimes);

        System.out.println("\nHyperClass Shopping");
        System.out.println("Av. Cassiano Ricardo, 601 - Jd Aquarius");
        System.out.println("________________________________________");
        System.out.println(formatter.format(order.getOrderDate()));
        System.out.println("CREDIT CARD"); // editar tbm pro nome correto do arquivo... pode ser credito e pode ser debito
        for (Item product : order.getItens()) {
            System.out.println("Product: " + product.getProductItem());
            System.out.println("Quantity: " + product.getQuantityItem());
            System.out.printf("Subtotal: R$%.2f\n", product.getSubtotal());
        }
        System.out.println("--");
        System.out.printf("Total:  RS%.2f", order.getTotal());
        System.out.println("\nInstallments: " + informedInstallmentsTimes);
        System.out.printf("Total each installments: RS%.2f", credit.getInstallmentsValue(order.getTotal(), informedInstallmentsTimes)); // diminuir esse metodo
        System.out.println("\n________________________________________");
    }
}
