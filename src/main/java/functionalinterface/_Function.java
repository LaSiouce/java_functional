package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiplyBy10 = multiplyBy10Function.apply(increment2);
        System.out.println(multiplyBy10);

        // Combine functions with andThen
        Function<Integer, Integer> addByOneAndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addByOneAndThenMultiplyBy10.apply(4));

        // BiFunction takes 2 arguments and produces 1 result
        System.out.println(
                incrementByOneAndMultiply(4, 100)
        );

        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4, 100)
        );
    }

    // Functional style
    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function =
            number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultuplyBy) ->
                    (numberToIncrementByOne + 1) * numberToMultuplyBy;

    // Classic style
    static int incrementByOne(int number) {
        return number + 1;
    }

    static int incrementByOneAndMultiply(int number, int numToMulptiply) {
        return (number + 1) * numToMulptiply;
    }
}
