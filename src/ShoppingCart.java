package src;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  private List<Product> products;

  public ShoppingCart() {
    this.products = new ArrayList<Product>();
  }

  public void addProudct(Product product) {
    this.products.add(product);
  }


}