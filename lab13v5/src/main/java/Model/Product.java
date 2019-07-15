package Model;

public class Product  {

  public  Product(){

    }

    public Product(int id, String name, String description, String stock, String supplier, String price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.supplier = supplier;
        this.price = price;
    }

    private  int id;
    private String name;
    private String description;
    private String stock;
    private String supplier;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
