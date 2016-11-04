package salestaxes;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class BasketUTest {

  @Test
  public void testZeroItems() {
    Basket basket = new Basket("1");
    BigDecimal salesTaxes = basket.evalSalesTaxes();
    BigDecimal total = basket.evalTotal();
    Assert.assertEquals(salesTaxes, Consts.ZERO);
    Assert.assertEquals(total, Consts.ZERO);
  }
}
