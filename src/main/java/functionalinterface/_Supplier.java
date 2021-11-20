package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlListSupplier.get());
    }

    private static String getDBConnectionUrl() {
        return "jdbc://localhost:5423/zer";
    }

    // Supplier to return data value
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5423/zer";
    static Supplier<List<String>> getDBConnectionUrlListSupplier = () -> List.of(
            "jdbc://localhost:5423/ze",
            "jdbc://localhost:5423/parti"
    );
}
