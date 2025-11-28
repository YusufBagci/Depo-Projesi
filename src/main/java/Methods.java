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

        Product yeniProduct = new Product(isim, ureticiIsmi, birim);

        urunMap.put(yeniProduct.getId(), yeniProduct); //ürünü Listeye ekledik
        System.out.println("ürününüz "+yeniProduct.getId()+" id numarası ile eklenmiştir");
        pressEnter();
    }

    public static void urunListeleme() { //deneme denem2
        System.out.printf("%-5s %-10s %-15s %-10s %-10s %-10s%n", "id", "ismi", "üreticisi", "miktar", "birimi", "raf");
        System.out.println("------------------------------------------------------------");
        urunMap.values().forEach(System.out::println);
    }
    public static void urunGirisi() {
        System.out.println("--- ÜRÜN GİRİŞİ ---");
        urunListeleme(); // Girmeden önce ürün id görmek için.

        System.out.print("Giriş yapmak istediğiniz ürün ID: ");
        int id = getIntTryCatch();
        if (!urunMap.containsKey(id)) { //ürün yoksa çıkış
            System.err.println("Bu ID sistemde kayıtlı değil.");
            pressEnter();
            return;
        }
        System.out.println("Giriş yapmak istediğiniz ürün miktarını giriniz: ");
        int girilenMiktar = getIntTryCatch();

        if (girilenMiktar <= 0) {
            System.err.println(" HATA: Ürün girişi 0 veya negatif olamaz!");
            pressEnter();
            return;
        }

        Product urun = urunMap.get(id);
        urun.setMiktar(urun.getMiktar() + girilenMiktar);
        System.out.println("Yeni miktar: " + urun.getMiktar());
        pressEnter();
    }

    public static void urunCikis() {
        System.out.println("--- ÜRÜN ÇIKIŞI ---");
        urunListeleme();

        System.out.print("Çıkış yapmak istediğiniz ürün ID: ");
        int id = getIntTryCatch();

        if (!urunMap.containsKey(id)) { //id si verilen ürün varmı kontrol
            System.err.println("Bu ID sistemde kayıtlı değil.");
            pressEnter();
            return;
        }
        Product urun = urunMap.get(id);
        if (urun.getMiktar() == 0) {// ürünün miktarı zaten 0'sa kontrolü
            System.err.println("Girdiğiniz id deki ürünün miktarı zaten 0");
            pressEnter();
            return;
        }
        System.out.println("Çıkış yapmak istediğiniz ürün miktarını giriniz: ");
        int girilenMiktar = getIntTryCatch();
        if (girilenMiktar > urun.getMiktar() || girilenMiktar < 0) {
            System.err.println("Var olan ürün miktarından fazla ürün çıkışı yapamazsınız ve girilen miktar negatif olamaz");
            pressEnter();
            return;
        }
        urunMap.get(id).setMiktar(urun.getMiktar() - girilenMiktar);
        System.out.println("Ürün çıkışı başarılı. Kalan ürün miktarı: " + urun.getMiktar());
        pressEnter();
    }

    public static void rafaEkle() {
        urunListeleme();
        System.out.println("Rafa eklemek istediğiniz ürünün id numarasasını giriniz");
        int id = getIntTryCatch();
        if (!urunMap.containsKey(id)) { //id yoksa direk dön
            System.err.println("Girdiğiniz id'de bir ürün bulunmuyor");
            pressEnter();
            return;
        }
        Product product = urunMap.get(id); //hashten aldığımız objeyi atıyoruz

        System.out.println("Hangi rafa eklensin");
        String raf = input.nextLine();
        if (raf.isBlank()) { //response boş geçilirse return
            System.err.println("Raf ismi boş geçilemez");
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
    public static int getIntTryCatch(){

        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Lütfen sadece sayısal değer giriniz");
            }
        }
    }



}

