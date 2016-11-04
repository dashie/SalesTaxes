package salestaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 */
public final class SalesTaxesUtils {

  public static final BigDecimal ROUND5CENTS = new BigDecimal("0.05");

  /**
   * 
   * @param n
   * @return
   */
  public static final BigDecimal roundTo5Cents(BigDecimal n) {
    Objects.requireNonNull(n, "n");
    BigDecimal r = n.divide(ROUND5CENTS, 0, RoundingMode.CEILING)
        .multiply(ROUND5CENTS)
        .setScale(2);
    return r;
  }
}
