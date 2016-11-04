package salestaxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class SalesTaxes {

  private static final Pattern BASKET_FIRST_LINE_PATTERN = Pattern.compile("Input ([1-9][0-9]*):");

  private static final Pattern ITEM_LINE_PATTERN = Pattern.compile("([1-9][0-9]*) (.+) at ([0-9]+\\.[0-9][0-9])");

  /**
   * 
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    SalesTaxes salesTaxes = new SalesTaxes();
    String receipts = salesTaxes.printReceipts(System.in);
    System.out.print(receipts);
  }

  /**
   * 
   * @param in
   * @throws IOException
   */
  public String printReceipts(InputStream in) throws IOException {

    StringWriter buffer = new StringWriter(1024);
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(in)); PrintWriter writer = new PrintWriter(buffer)) {

      String line;
      while ((line = reader.readLine()) != null) {
        if (line.isEmpty()) {
          continue;
        }
        Matcher matcher = BASKET_FIRST_LINE_PATTERN.matcher(line);
        if (matcher.matches()) {
          String id = matcher.group(1);
          Basket basket = readBasket(reader, id);
          String receipt = basket.printReceipt();
          writer.println(receipt);
        } else {
          // TODO Explain better the exception  
          throw new IOException("Invalid data");
        }
      }
    }
    return buffer.toString();
  }

  /**
   * 
   * @param reader
   * @param id
   */
  private Basket readBasket(BufferedReader reader, String id) throws IOException {

    Basket basket = new Basket(id);
    String line;
    while ((line = reader.readLine()) != null) {
      if (line.isEmpty()) {
        break;
      }
      Item item = readItem(line);
      basket.addItem(item);
    }
    return basket;
  }

  /**
   * 
   * @param str
   * @return
   */
  private Item readItem(String str) {

    Matcher matcher = ITEM_LINE_PATTERN.matcher(str);
    if (matcher.matches()) {
      try {
        int quantity = Integer.parseInt(matcher.group(1));
        String name = matcher.group(2);
        boolean imported = name.indexOf("imported ") != -1;
        if (imported) {
          name = name.replaceAll("imported ", "");
        }
        String value = matcher.group(3);
        Product product = Catalog.SINGLETON.find(name);
        return new Item(quantity, imported, product, value);
      } catch (Exception ex) {
        throw new IllegalArgumentException(str, ex);
      }
    } else {
      throw new IllegalArgumentException(str);
    }
  }
}
