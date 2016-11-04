package salestaxes;

import java.math.BigDecimal;

/**
 *
 */
public final class Taxes {

  public static final BigDecimal NO_TAX = BigDecimal.valueOf(0, 2);

  public static final BigDecimal SALES_TAX = BigDecimal.valueOf(10, 2);

  public static final BigDecimal IMPORT_TAXES = BigDecimal.valueOf(5, 2);

  /**
   * 
   */
  private Taxes() {
  }
}
