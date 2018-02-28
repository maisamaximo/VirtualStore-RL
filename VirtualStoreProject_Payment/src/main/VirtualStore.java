package main;


import data.*;
import payment.Payment;
import payment.PaymentForm;
import payment.PaymentType;
import view.PrintInformations;
import view.ViewPaymentStrategy;


import java.util.Scanner;

public class VirtualStore {

    Scanner read = new Scanner(System.in);

    private final PrintInformations printInformations = new PrintInformations();
    private final ShoppingCart shoppingCart = new ShoppingCart();
    private final ProductList productList = new ProductList();
    private final Payment payment = new Payment();
    private Client currentClient;
    private ClientList client = new ClientList();

    public void start(){
         String addItemOption;
         String informedProduct;
         int informedQuantity;
         String informedEmail;
         int informedPaymentForm;
         boolean continueRequest = true;

        do{
            showProductList();
            printInformations.requestAddItem();
            addItemOption = read.next();
            if (addItemOption.equalsIgnoreCase("Y")){
               // showProductList();
                printInformations.requestProduct();
                informedProduct = read.next();
                printInformations.requestQuantity();
                informedQuantity = read.nextByte();

                shoppingCart.addItemAtList(productList.getItem(informedProduct), informedQuantity);

            }else if (addItemOption.equalsIgnoreCase("N")){
                continueRequest = false;
                printInformations.requestEmailAddress();
                informedEmail = read.next();

                currentClient = client.getCurrentClient(informedEmail);

                printInformations.requestPaymentForm();
                informedPaymentForm = read.nextByte();


                //deveria receber paymentType
                Order currentOrder = new Order(shoppingCart.getItensList(), payment.getPaymentType());
                currentClient.addOrder(currentOrder);

                getPaymentOption(informedPaymentForm).executeView(currentOrder);

                //teste para verificar se o cliente foi adicionado a lista
                System.out.println(currentClient.getClientEmail());
                System.out.println(currentOrder.getPaymentType());

            }
        }while (continueRequest);
    }

    private void showProductList(){
        ProductList productList = new ProductList();
        printInformations.productList();
        for (Product product : productList.getProductsList())
            System.out.printf("%s     R$%.2f\n", product.getProductName(), product.getProductPrice());
    }

    private ViewPaymentStrategy getPaymentOption(int informedPaymentForm) {
        return payment.paymentExecute(informedPaymentForm);
    }
}
