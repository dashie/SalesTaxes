package salestaxes;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class SalesTaxesUTest {

  private static final String EXPECTED_OUTPUT;

  static {
    try {
      EXPECTED_OUTPUT = IOUtils.toString(SalesTaxes.class.getResourceAsStream("/output.txt"));
    } catch (Exception ex) {
      throw new ExceptionInInitializerError(ex);
    }
  }

  @Test
  public void testPrintOutput() throws Exception {

    SalesTaxes salesTaxes = new SalesTaxes();
    InputStream input = SalesTaxes.class.getResourceAsStream("/input.txt");
    String output = salesTaxes.printReceipts(input);
    Assert.assertEquals("Output test failed", EXPECTED_OUTPUT, output);
  }
}
