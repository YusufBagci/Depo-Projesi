import java.util.HashMap;
import java.util.Scanner;

public class Methods {
    static Scanner input = new Scanner(System.in);

    static HashMap<Integer, Product> urunMap = new HashMap<>(); //id ve ürün objesi koyulacak

    public static void urunTanimla() {
        System.out.print("Ürün ismi: ");
        String isim = input.nextLine();

        System.out.print("Üretici ismi: ");
        String ureticiIsmi = input.nextLine();

        System.out.print("Birim (çuval, litre, kg vs.): ");
        String birim = input.nextLine();

        Product yeniProduct = new Product(Product.idCounter, isim, ureticiIsmi, birim);

        urunMap.put(Product.idCounter, yeniProduct); //ürünü Listeye ekledik
        pressEnter();
    }

    public static void urunListeleme() { //deneme denem2
        System.out.printf("%-5s %-10s %-15s %-10s %-10s %-10s%n", "id", "ismi", "üreticisi", "miktar", "birimi", "raf");
        System.out.println("------------------------------------------------------------");
        for (Product u : urunMap.values()) { //
            System.out.println(u);
        }
    }
    public static void urunGirisi() {
        System.out.println("--- ÜRÜN GİRİŞİ ---");
        urunListeleme(); // Girmeden önce ürün id görmek için.

        System.out.print("Giriş yapmak istediğiniz ürün ID: ");
        int id = Integer.parseInt(input.nextLine());
        if (urunMap.containsKey(id)) {
            System.out.println("Giriş yapmak istediğiniz ürün miktarını giriniz: ");
            int girilenMiktar = Integer.parseInt(input.nextLine());

            if (girilenMiktar <= 0) {
                System.out.println(" HATA: Ürün girişi 0 veya negatif olamaz!");
                pressEnter();
                return; // Metodu burada bitir, aşağıya inme.
            }

            Product urun = urunMap.get(id);
            urun.setMiktar(urun.getMiktar() + girilenMiktar);
            System.out.println("Yeni miktar: " + urun.getMiktar());
            pressEnter();
        } else {
            System.out.println("Bu ID sistemde kayıtlı değil.");
            pressEnter();
        }
    }

    public static void rafaEkle() {
        urunListeleme();
        System.out.println("Rafa eklemek istediğiniz ürünün id numarasasını giriniz");
        int id = Integer.parseInt(input.nextLine());
        if (!urunMap.containsKey(id)) { //id yoksa direk dön
            System.out.println("Girdiğiniz id'de bir ürün bulunmuyor");
            pressEnter();
            return;
        }
        Product product = urunMap.get(id); //hashten aldığımız objeyi atıyoruz

        System.out.println("Hangi rafa eklensin");
        String raf = input.nextLine();
        if (raf.isBlank()) { //response boş geçilirse return
            System.out.println("Raf ismi boş geçilemez");
            pressEnter();
            return;
        }
        product.setRaf(raf); //raf değişikliği burada

        System.out.println(product.getUrunIsmi()+" ürünü "+product.getRaf()+" rafına başarılı bir şekilde eklendi");
        pressEnter();
    }

    public static void pressEnter() {
        System.out.println("Devam etmek için Enter'a basınız...");
        input.nextLine();
    }



}

