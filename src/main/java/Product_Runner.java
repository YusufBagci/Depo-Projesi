import java.util.Scanner;

public class Product_Runner {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        logoff:
        while (true) {
            System.out.println("""
                    Lütfen yapmak istediğini işlemi seçiniz\
                    
                    1-)Ürün tanımlama\
                    
                    2-)Ürün listeleme\
                    
                    3-)Ürün girişi\
                    
                    4-)Ürünü rafa koyma\
                    
                    5-)Ürün çıkışı\
                    
                    6-)Sistemden Çıkışlar""");
            int selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1:
                    Methods.urunTanimla();
                    break;
                case 2://Ürün listeleme
                    Methods.urunListeleme();
                    break;
                case 3://Ürün girişi
                    break;
                case 4://Ürün çıkışı
                    break;
                case 5://Ürünü rafa koyma
                    break;
                case 6://Sistemden Çıkış
                    break logoff;
            }
        }

    }
}
