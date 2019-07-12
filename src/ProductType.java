package src;

public enum ProductType {
  BOOK(0.0),
  FOOD(0.0),
  MEDICAL(0.0),
  OTHER(0.1);

  private Double tax;

  ProductType(Double tax) {
    this.setTax(tax);
  }

  public void setTax(Double tax) {
    this.tax = tax;
  }

  public Double getTax() {
    return this.tax;
  }
  
}