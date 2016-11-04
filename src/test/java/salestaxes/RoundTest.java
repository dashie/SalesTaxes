package salestaxes;

import java.math.BigDecimal;

import org.junit.Ignore;

/**
 *
 */
@Ignore
public class RoundTest {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {

    for (int i = 0; i < 100; ++i) {
      String s = "1." + (i < 10 ? "0" + i : i);
      BigDecimal n = new BigDecimal(s);
      BigDecimal r = SalesTaxesUtils.roundTo5Cents(n);
      System.out.println(n + " ≈ " + r);
    }
  }
}
