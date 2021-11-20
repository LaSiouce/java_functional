package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0211158",
                LocalDate.of(2000, 1, 1)
        );
        // Using combinator pattern
        ValidationResult result = isAnAdult()
                .and(isEmailValid())
                .and(isPhoneNumberValid())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCESS) {
            throw new IllegalStateException((result.name()));
        }
    }
}
