public class ShoppingCartDemo {
    public static void main(String[] args) {
        PaymentStrategyFactory paymentStrategyFactory = new PaymentStrategyFactory();
        ShoppingCart cart = new ShoppingCart(paymentStrategyFactory);

        Product product1 = new Product("Item 1", 10.0, 2);
        Product product2 = new Product("Item 2", 15.0, 1);

        cart.addProduct(product1);
        cart.addProduct(product2);

        System.out.println("Cart Total: $" + cart.calculateTotalPrice());

        // Choose a payment strategy type and provide the necessary arguments
        String paymentType = "creditCard";
        String cardNumber = "1234-5678-9012-3456";
        String cardHolder = "John Doe";

        // Complete the checkout using the selected payment strategy type and arguments
        cart.checkout(paymentType, cardNumber, cardHolder);
    }
}
