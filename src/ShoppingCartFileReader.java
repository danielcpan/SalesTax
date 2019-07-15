package src;

import java.io.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingCartFileReader {

  private static final String QUANTITY_REGEX = "^[\\d+]+";
  private static final String NAME_REGEX = "(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)";
  private static final String PRICE_REGEX = "\\d+\\.\\d+";
  private static final String IS_IMPORTED_REGEX = "imported";
  private static final String IS_EXEMPT_REGEX = "book|chocolate|pills";

  public ShoppingCartFileReader(File file, ShoppingCart cart) {
		try {
      BufferedReader in = new BufferedReader(new FileReader(file));
      String line = in.readLine();
			while (line != null) {
        System.out.println(line);
        int quantity = this.getQuantity(line);
        String name = this.getName(line);
        Double price = this.getPrice(line);
        ProductType type = ProductType.getProductType(line);
        Boolean isExempt = this.getIsExempt(line);
        Boolean isImported = this.getIsImported(line);

        // System.out.println("quantity: " + quantity);
        // System.out.println("name: " + name);        
        // System.out.println("price: " + price);        
        // System.out.println("type: " + type);        
        // System.out.println("isExempt: " + isExempt);        
        // System.out.println("isImported: " + isImported);

        Product product = new Product(quantity, name, price, type, isExempt, isImported);
        // System.out.println("After Tax: " + product.getPriceAfterTax());
        cart.addProudct(product);
				line = in.readLine();
      }
      in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
    }
  }
	  
  private int getQuantity(String line) {
    Pattern p = Pattern.compile(QUANTITY_REGEX);
    Matcher m = p.matcher(line);
    m.find();
    return Integer.parseInt(m.group(0));
  }

  private String getName(String line) {
    Pattern p = Pattern.compile(NAME_REGEX);
    Matcher m = p.matcher(line);
    m.find();
    return m.group(0);
  }

  private Double getPrice(String line) {
    Pattern p = Pattern.compile(PRICE_REGEX);
    Matcher m = p.matcher(line);
    m.find();
    return Double.parseDouble(m.group(0));
  }  

  private boolean getIsImported(String line) {
    Pattern p = Pattern.compile(IS_IMPORTED_REGEX);
    return p.matcher(line).find();
  }
  
  private boolean getIsExempt(String line) {
    Pattern p = Pattern.compile(IS_EXEMPT_REGEX);
    return p.matcher(line).find();
  }
}