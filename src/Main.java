import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Șampon", 20, 250, LocalDate.of(2024, 6, 30)));
        products.add(new Product("Balsam de păr", 45, 300, LocalDate.of(2024, 9, 5)));
        products.add(new Product("Deodorant", 30, 80, LocalDate.of(2025, 7, 15)));
        products.add(new Product("Pastă de dinți", 40, 98, LocalDate.of(2024, 9, 20)));
        products.add(new Product("Gel de duș", 25, 150, LocalDate.of(2024, 5, 20)));
        products.add(new Product("Loțiune tonică", 30, 120, LocalDate.of(2024, 8, 15)));
        products.add(new Product("Cremă de corp", 18, 180, LocalDate.of(2024, 9, 18)));
        products.add(new Product("Cremă hidratantă", 35, 105, LocalDate.of(2024, 7, 30)));
        products.add(new Product("Gel de ras", 30, 80, LocalDate.of(2024, 9, 15)));
        products.add(new Product("Balsam de buze", 60, 60, LocalDate.of(2024, 8, 5)));
        products.add(new Product("Ser pentru ten", 20, 250, LocalDate.of(2024, 12, 20)));
        products.add(new Product("Mascara", 13, 600, LocalDate.of(2024, 10, 10)));
        products.add(new Product("Săpun lichid", 50, 80, LocalDate.of(2024, 7, 20)));
        products.add(new Product("Periuță de dinți", 80, 95, LocalDate.of(2024, 5, 15)));
        products.add(new Product("Rimel", 10, 650, LocalDate.of(2024, 11, 30)));
        products.add(new Product("Exfoliant corporal", 180, 20.0, LocalDate.of(2024, 10, 15)));
        products.add(new Product("Spumă de ras", 0, 110, LocalDate.of(2024, 8, 5)));
        products.add(new Product("Șampon uscat", 25, 80, LocalDate.of(2024, 9, 30)));
        products.add(new Product("Spray fixativ pentru păr", 16, 200, LocalDate.of(2024, 10, 25)));
        products.add(new Product("Demachiant", 0, 170, LocalDate.of(2024, 11, 15)));

        ProductService productService = new ProductService(products);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n====== Meniu Principal ======");
            System.out.println("1. Filtrare produse");
            System.out.println("2. Sortare produse dupa nume");
            System.out.println("3. Grupare produse dupa cantitate");
            System.out.println("4. Calculare valoare totala a stocului");
            System.out.println("5. Găsirea celui mai scump produs");
            System.out.println("6. Afișare produse cu data de expirare în viitor");
            System.out.println("0. Ieșire");
            System.out.print("Selectati optiunea: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    productService.filtrareDupaPret();
                    break;
                case 2:
                    System.out.print("Sortare A->Z (1) sau Z->A (2): ");
                    int sortOrder = scanner.nextInt();
                    boolean ascending = sortOrder == 1;
                    productService.sortareDupaNume(ascending);
                    break;
                case 3:
                    productService.grupareDupaCantitate();
                    break;
                case 4:
                    System.out.println("Valoarea totala a stocului: " + productService.stockTotal());
                    break;
                case 5:
                    System.out.println("Cel mai scump produs: " + productService.celMaiScumpProdus());
                    break;
                case 6:
                    productService.expirare();
                    break;
                case 0:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Optiune invalida.");
            }
        } while (choice != 0);
    }
}
