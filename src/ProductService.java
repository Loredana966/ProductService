import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public void filtrareDupaPret() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Interval de preturi");
        System.out.println("2. Buget maxim");
        System.out.println("3. Buget minim");
        System.out.print("Selectati optiunea: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.print("Introduceti pretul minim: ");
                double minPrice = scanner.nextDouble();
                System.out.print("Introduceti pretul maxim: ");
                double maxPrice = scanner.nextDouble();
                products.stream()
                        .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                        .forEach(System.out::println);
                break;
            case 2:
                System.out.print("Introduceti bugetul maxim: ");
                double maxBudget = scanner.nextDouble();
                products.stream()
                        .filter(p -> p.getPrice() <= maxBudget)
                        .forEach(System.out::println);
                break;
            case 3:
                System.out.print("Introduceti bugetul minim: ");
                double minBudget = scanner.nextDouble();
                products.stream()
                        .filter(p -> p.getPrice() >= minBudget)
                        .forEach(System.out::println);
                break;
            default:
                System.out.println("Optiune invalida.");
        }
    }

    public void sortareDupaNume(boolean ascending) {
        Comparator<Product> comparator = Comparator.comparing(Product::getProductName);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        products.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    public void grupareDupaCantitate() {
        Map<Integer, List<Product>> groupedByQuantity = products.stream()
                .collect(Collectors.groupingBy(Product::getStock));
        groupedByQuantity.forEach((stock, productList) -> {
            System.out.println("Stock: " + stock);
            productList.forEach(System.out::println);
        });
    }

    public double stockTotal() {
        return products.stream()
                .mapToInt(Product::getStock)
                .sum();
    }

    public Product celMaiScumpProdus() {
        return products.stream()
                .max(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    public void expirare() {
        products.stream()
                .filter(p -> p.getExpiryDate().isAfter(LocalDate.now()))
                .forEach(System.out::println);
    }
}
