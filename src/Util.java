package src;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {
  public static double round(double amount) {
    return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  public static double roundToNearest5Percent(double amount) {
    return new BigDecimal(Math.ceil(amount * 20)/20).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }
}