package optionnals;

import java.util.Optional;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Pas de mail frerot"));

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("Les tchouch");

        Object value = Optional.ofNullable(null)
                .orElseThrow(exception);

        System.out.println(value);

    }
}
