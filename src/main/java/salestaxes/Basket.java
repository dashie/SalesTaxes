package salestaxes;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A basket of items.
 */
public class Basket {

  private String id;

  private List<Item> items = new ArrayList<>();

  /**
   * 
   * @param id
   */
  public Basket(String id) {
    Objects.requireNonNull(id, "id");
    this.id = id;
  }

  /**
   * Add an {@link Item} to the {@link Basket}.
   * 
   * @param item
   */
  public void addItem(Item item) {
    Objects.requireNonNull(item, "item");
    items.add(item);
  }

  /**
   * 
   * @return
   */
  public BigDecimal evalSalesTaxes() {

    BigDecimal v = Consts.ZERO;
    for (Item item : items) {
      v = v.add(item.getTaxes());
    }
    return v;
  }

  /**
   * 
   * @return
   */
  public BigDecimal evalTotal() {

    BigDecimal v = Consts.ZERO;
    for (Item item : items) {
      v = v.add(item.getTaxedValue());
    }
    return v;
  }

  /**
   * Printing a receipt from a {@link Basket} to a {@link String}.
   * 
   * @return
   */
  public String printReceipt() {

    StringWriter buffer = new StringWriter(256 + 128 * items.size());
    try (PrintWriter writer = new PrintWriter(buffer)) {

      writer.print("Output ");
      writer.print(id);
      writer.println(":");

      for (Item item : items) {
        writer.println(item);
      }

      BigDecimal taxes = evalSalesTaxes();
      BigDecimal total = evalTotal();
      writer.println("Sales Taxes: " + taxes);
      writer.println("Total: " + total);
    }
    return buffer.toString();
  }
}
