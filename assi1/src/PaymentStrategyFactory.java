public class PaymentStrategyFactory {
    public PaymentStrategy createPaymentStrategy(String type, String... args) {
        switch (type) {
            case "creditCard":
                if (args.length == 2) {
                    return new CreditCardPayment(args[0], args[1]);
                }
                break;
            case "paypal":
                if (args.length == 1) {
                    return new PayPalPayment(args[0]);
                }
                break;
        }
        throw new IllegalArgumentException("Invalid payment strategy type or arguments.");
    }
}
