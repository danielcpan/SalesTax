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

  public void emptyCart() {
    this.products.clear();
  }

  public Double getSalesTax() {
    double salesTax = 0;
    for (int i = 0; i < this.products.size(); i++) {
      Product product = this.products.get(i);
      salesTax += product.getSalesTax();
    }
    return Util.round(salesTax);
  }

  public Double getTotal() {
    double total = 0;
    for (int i = 0; i < this.products.size(); i++) {
      Product product = this.products.get(i);
      total += product.getPriceAfterTax();
    }
    return Util.round(total);
  }

  public void printReciept() {
    for (int i = 0; i < this.products.size(); i++) {
      Product product = this.products.get(i);
      System.out.println(product.getQuantity() + " " + product.getName() + ": " + product.getPriceAfterTax());
    }
    System.out.printf("Sales Tax: %.2f", this.getSalesTax());
    System.out.printf("\nTotal: %.2f", this.getTotal());
  }
}