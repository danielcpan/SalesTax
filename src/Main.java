package src;

import java.io.File;

public class Main {
  public static void main(String[] args) {
    ShoppingCart cart = new ShoppingCart();

    File folder = new File("inputFiles/");
    File[] listOfFiles = folder.listFiles();
    
    for (File file : listOfFiles) {
      if (file.isFile()) {
        System.out.println(file.getName());
        File inputFile = new File("inputFiles/" + file.getName());
        
        ShoppingCartFileReader scfr = new ShoppingCartFileReader(inputFile, cart);
        System.out.println("receipt: ");
        cart.printReciept();
        System.out.println();
        System.out.println();
        cart.emptyCart();
      }
    }  
  }
}