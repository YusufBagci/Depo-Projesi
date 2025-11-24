public class Product {
    static int idCounter;
    private int id = 1000;
    private String urunIsmi;
    private String uretici;
    private String birim;
    private int miktar = 0;   //ürün tanımlamasında mikttar ve raf girilmiyor o yüzden default değerlerini atayacağız
    private String raf = null;

    public Product(int id, String urunIsmi, String uretici, String birim) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
        idCounter++;
    }

    //getters setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %-10d %-10d %-10s", id, urunIsmi, uretici, miktar, birim, raf);
    }
}
