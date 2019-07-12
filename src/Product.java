package src;

public class Product {

  private String name;
  private Double price;
  private ProductType type;
  private Boolean isExempt;
  private Boolean isImported;

  public Product(String name, Double price, ProductType type, Boolean isExempt, Boolean isImported) {
    this.name = name;
    this.price = price;
    this.type = type;
    this.isExempt = isExempt;
    this.isImported = isImported;
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

  public Double getPriceAfterTax() {
    return 0.0;
  }
}