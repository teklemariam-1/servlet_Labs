package DAO;

import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {



    Map<Integer, Product> products = new HashMap<Integer,Product>();

    {

        products.put(1, new Product(1, "iPohne", "Mobile","500","Apple","200"));
        products.put(2, new Product(2, "LG G6", "Mobile","1000","Google","650"));
        products.put(3, new Product(3, "S7 Edge", "Mobile","200","Samsung","750"));
    }

    public Object getProduct(int id) {
        return products.get(id);
    }

    public void addProduct(Product product) {

        products.put(product.getId(), product);
    }



    public void deleteProduct(int productId) {

        products.remove(productId);
        System.out.println("product successfully deleted");
    }

    public void updateProduct(Product product) {
        products.put(product.getId(), product);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<Product>(products.values());
    }

    public Product getProductById(int productId) {
        return products.get(productId);
    }

    public int genId() {
        return products.size() + 1;
    }
}



