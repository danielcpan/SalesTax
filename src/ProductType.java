package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProductType {
  BOOK(0.0),
  FOOD(0.0),
  MEDICAL(0.0),
  OTHER(0.1);

  private Double tax;

  ProductType(Double tax) {
    this.tax = tax;
  }

  public Double getTax() {
    return this.tax;
  }

  public static ProductType getProductType(String line) {
    Pattern p = Pattern.compile("(book)|(chocolate)|(pills)");
    Matcher m = p.matcher(line);
    if (m.find()) {
      switch(m.group(0)) {
        case "book":
          return BOOK;
        case "chocolate":
          return FOOD;
        case "pills":
          return MEDICAL;
      }
    }
    return OTHER;
  }
  
}