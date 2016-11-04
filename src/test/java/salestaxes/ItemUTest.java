package salestaxes;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import salestaxes.Product.Type;

/**
 *
 */
public class ItemUTest {

  private static final Product SAMPLE_TAXED_PRODUCT = new Product("sample taxed product", Type.OTHER);

  private static final Product SAMPLE_NO_TAXED_PRODUCT = new Product("sample notaxed product", Type.BOOK);

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQuantityNegative() {
    new Item(-1, false, SAMPLE_TAXED_PRODUCT, "1.00");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQuantityZero() {
    new Item(0, false, SAMPLE_TAXED_PRODUCT, "1.00");
  }

  @Test(expected = NullPointerException.class)
  public void testNullProduct() {
    new Item(1, false, null, "1.00");
  }

  @Test(expected = NullPointerException.class)
  public void testNullValue() {
    new Item(1, false, SAMPLE_TAXED_PRODUCT, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalValueNegative() {
    new Item(1, false, SAMPLE_TAXED_PRODUCT, "-1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalValueZero() {
    new Item(1, false, SAMPLE_TAXED_PRODUCT, "0");
  }

  @Test
  public void testNoTax() {
    Item item = new Item(1, false, SAMPLE_NO_TAXED_PRODUCT, "1.00");
    BigDecimal taxedValue = item.getTaxedValue();
    Assert.assertEquals(new BigDecimal("1.00"), taxedValue);
  }

  @Test
  public void testSalesTaxOnly() {
    Item item = new Item(1, false, SAMPLE_TAXED_PRODUCT, "1.00");
    BigDecimal taxedValue = item.getTaxedValue();
    Assert.assertEquals(new BigDecimal("1.10"), taxedValue);
  }

  @Test
  public void testImportedTaxOnly() {
    Item item = new Item(1, true, SAMPLE_NO_TAXED_PRODUCT, "1.00");
    BigDecimal taxedValue = item.getTaxedValue();
    Assert.assertEquals(new BigDecimal("1.05"), taxedValue);
  }

  @Test
  public void testSalesImportedTax() {
    Item item = new Item(1, true, SAMPLE_TAXED_PRODUCT, "1.00");
    BigDecimal taxedValue = item.getTaxedValue();
    Assert.assertEquals(new BigDecimal("1.15"), taxedValue);
  }
}
