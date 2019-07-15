package src;

public class Product {
  private int quantity;
  private String name;
  private Double price;
  private ProductType type;
  private Boolean isExempt;
  private Boolean isImported;

  public Product(int quantity, String name, Double price, ProductType type, Boolean isExempt, Boolean isImported) {
    this.quantity = quantity;
    this.name = name;
    this.price = price;
    this.type = type;
    this.isExempt = isExempt;
    this.isImported = isImported;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getQuantity() {
    return this.quantity;
  }  

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setIsExempt(Boolean isExempt) {
    this.isExempt = isExempt;
  }

  public Boolean getIsExempt() {
    return this.isExempt;
  }

  public void setIsImported(Boolean isImported) {
    this.isImported = isImported;
  }

  public Boolean getIsImported() {
    return this.isImported;
  }

  public Double getSalesTax() {
    double salesTax = this.price * (this.type.getTax() + this.getImportTax());
    return Util.roundToNearest5Percent(salesTax);
  }

  public Double getPriceAfterTax() {
    double priceAfterTax = this.price + this.getSalesTax();
    return Util.round(priceAfterTax);
  }

  public Double getImportTax() {
    return isImported ? 0.05 : 0.0;
  } 
}