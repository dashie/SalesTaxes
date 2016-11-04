package salestaxes;

import static org.junit.Assert.assertEquals;
import static salestaxes.SalesTaxesUtils.roundTo5Cents;

import java.math.BigDecimal;

import org.junit.Test;

/**
 *
 */
public class RoundUTest {

  @Test
  public void testZero() {
    assertEquals("0.00 test failed", new BigDecimal("0.00"), roundTo5Cents(new BigDecimal("0.00")));
  }

  @Test
  public void testRound() {
    assertEquals("0.01 test failed", new BigDecimal("0.05"), roundTo5Cents(new BigDecimal("0.01")));
    assertEquals("0.04 test failed", new BigDecimal("0.05"), roundTo5Cents(new BigDecimal("0.04")));
    assertEquals("0.09 test failed", new BigDecimal("0.10"), roundTo5Cents(new BigDecimal("0.09")));
    assertEquals("0.99 test failed", new BigDecimal("1.00"), roundTo5Cents(new BigDecimal("0.99")));
    assertEquals("0.55 test failed", new BigDecimal("0.55"), roundTo5Cents(new BigDecimal("0.55")));
    assertEquals("0.56 test failed", new BigDecimal("0.60"), roundTo5Cents(new BigDecimal("0.56")));
    assertEquals("1.00 test failed", new BigDecimal("1.00"), roundTo5Cents(new BigDecimal("1.00")));
    assertEquals("99999.94 test failed", new BigDecimal("99999.95"), roundTo5Cents(new BigDecimal("99999.94")));
    assertEquals("99999.99 test failed", new BigDecimal("100000.00"), roundTo5Cents(new BigDecimal("99999.99")));
  }

  @Test(expected = NullPointerException.class)
  public void testNull() {
    SalesTaxesUtils.roundTo5Cents(null);
  }

}
