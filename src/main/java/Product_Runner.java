import java.util.Scanner;

public class Product_Runner {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println();
        logoff:
        while (true) {
            System.out.println("""
                    Lütfen yapmak istediğini işlemi seçiniz\
                    
                    1-)Ürün tanımlama\
                    
                    2-)Ürün listeleme\
                    
                    3-)Ürün girişi\
                    
                    4-)Ürün çıkışı\
                    
                    5-)Ürünü rafa koyma\
                    
                    6-)Sistem Çıkış""");
            int selection = Integer.parseInt(input.nextLine());

            switch (selection) {
                case 1://ürün tanımlama
                    Methods.urunTanimla();
                    break;
                case 2://Ürün listeleme
                    Methods.urunListeleme();
                    break;
                case 3://Ürün girişi
                    Methods.urunGirisi();
                    break;
                case 4://Ürün çıkışı
                    break;
                case 5://Ürünü rafa koyma
                    Methods.rafaEkle();
                    break;
                case 6://Sistemden Çıkış
                    break logoff;
            }
        }

    }
}
