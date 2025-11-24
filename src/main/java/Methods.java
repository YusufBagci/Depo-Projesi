import java.util.HashMap;
import java.util.Scanner;

public class Methods {
    static Scanner input = new Scanner(System.in);

    static HashMap<Integer, Product> urunMap = new HashMap<>(); //id ve ürün objesi koyulacak

    public static void urunTanimla() {
        System.out.println("Ürün ismi: ");
        String isim = input.nextLine();

        System.out.println("Üretici ismi: ");
        String ureticiIsmi = input.nextLine();

        System.out.println("Birim (çuval, litre, kg vs.): ");
        String birim = input.nextLine();

        Product yeniProduct = new Product(Product.idCounter, isim, ureticiIsmi, birim);

        urunMap.put(Product.idCounter, yeniProduct); //ürünü Listeye ekledik
    }

    public static void urunListeleme() { //deneme denem2
        System.out.printf("%-5s %-7s %-10s %-10s %-10s %-10s%n", "id", "ismi", "üreticisi", "miktar", "birimi", "raf");
        System.out.println("---------------------------------------------------");
        for (Product u : urunMap.values()) { //
            System.out.println(u);
        }
    }


}

