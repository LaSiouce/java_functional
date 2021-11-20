package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // Ave Maria
        Customer maria = new Customer("Maria", "9843434");
        // Normal Java function
        greetCustomer(maria);
        // Consumer functional interface
        greetCustomerConsumer.accept(maria);
        // BiConsumer with phone number ...
        greetCustomerConsumerCanShowPhoneNumber.accept(maria, true);
        // ... without
        greetCustomerConsumerCanShowPhoneNumber.accept(maria, false);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + customer.customerPhoneNumber);
    static BiConsumer<Customer, Boolean> greetCustomerConsumerCanShowPhoneNumber = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "*******"));

    record Customer(String customerName, String customerPhoneNumber) {
    }
}
