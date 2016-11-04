package salestaxes;

import java.math.BigDecimal;

/**
 *
 */
public final class Consts {

  public static final BigDecimal ZERO = BigDecimal.valueOf(0, 2);

  public static final BigDecimal NO_TAX = ZERO;

  public static final BigDecimal SALES_TAX = BigDecimal.valueOf(10, 2);

  public static final BigDecimal IMPORT_TAX = BigDecimal.valueOf(5, 2);

  /**
   * 
   */
  private Consts() {
  }
}
