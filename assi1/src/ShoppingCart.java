import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cart = new ArrayList<>();
    private PaymentStrategy paymentStrategy;
    private DiscountStrategy discountStrategy;

    public void addProduct(Product product) {
        cart.add(product);
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product product : cart) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public void checkout(String paymentType, String cardNumber, String cardHolder) {
        double total = calculateTotalPrice();
        double discountedTotal = discountStrategy.applyDiscount(total);
        paymentStrategy.processPayment(discountedTotal);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
}
