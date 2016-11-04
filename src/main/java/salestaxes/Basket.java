package salestaxes;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public class Basket {

  private String id;

  private List<Item> items = new ArrayList<>();

  /**
   * 
   * @param id
   */
  public Basket(String id) {
    super();
    this.id = id;
  }

  /**
   * 
   * @param item
   */
  public void addItem(Item item) {
    Objects.nonNull(item);
    items.add(item);
  }

  /**
   * 
   * @return
   */
  public String printReceipt() {

    StringWriter buffer = new StringWriter(256 + 128 * items.size());
    try (PrintWriter writer = new PrintWriter(buffer)) {

      writer.print("Output ");
      writer.print(id);
      writer.println(":");

      BigDecimal taxes = new BigDecimal("0.00");
      BigDecimal total = new BigDecimal("0.00");

      for (Item item : items) {
        taxes = taxes.add(item.getTaxes());
        total = total.add(item.getTaxedValue());
        writer.println(item);
      }

      writer.println("Sales Taxes: " + taxes);
      writer.println("Total: " + total);
    }
    return buffer.toString();
  }
}
