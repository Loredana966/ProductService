import java.time.LocalDate;

public class Product {
    private String productName;
    private int stock;
    private double price;
    private boolean available;
    private LocalDate expiryDate;

    public Product(String productName, int stock, double price, LocalDate expiryDate) {
        this.productName = productName;
        this.stock = stock;
        this.price = price;
        this.available = stock >= 1;
        this.expiryDate = expiryDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        this.available = stock >= 1;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        String availability = available ? "produsul este disponibil" : "produsul nu este disponibil";
        String stockMessage = stock >= 20 ? " de bucăți" : " bucăți";
        return "Produs: " + productName +
                ", Preț: " + price +
                ", Disponibilitate: " + availability +
                ", În stoc mai sunt " + stock + stockMessage +
                ", Data expirării: " + expiryDate;
    }
}
