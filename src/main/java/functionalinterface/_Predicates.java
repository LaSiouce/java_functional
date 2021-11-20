package functionalinterface;

import java.util.function.Predicate;

public class _Predicates {
    public static void main(String[] args) {
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("07304568411"));
        System.out.println(isPhoneNumberValid("09004568411"));
        System.out.println(isPhoneNumberValid("070045684111"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07304568411"));
        System.out.println(isPhoneNumberValidPredicate.test("09004568411"));
        System.out.println(isPhoneNumberValidPredicate.test("070045684111"));

        //
        System.out.println(
                "Is phone number valid and contains 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("09004568411")
        );

        System.out.println(
                "Is phone number valid and contains 3 = " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("070104568411")
        );

        System.out.println(
                "Is phone number valid and contains 3 = " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("07014568411")
        );

    }
    // old school
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
    // functional way
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}
