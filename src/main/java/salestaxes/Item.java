package salestaxes;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 */
public class Item {

  private int quantity;

  private boolean imported;

  private Product product;

  private BigDecimal value;

  public Item() {
  }

  public Item(int quantity, boolean imported, Product product, String value) {
    if (quantity < 1) {
      throw new IllegalArgumentException("quantity");
    }
    Objects.requireNonNull(product, "product");
    Objects.requireNonNull(product, "value");
    this.quantity = quantity;
    this.imported = imported;
    this.product = product;
    this.value = new BigDecimal(value).setScale(2);
    if (this.value.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("value");
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(256);
    sb.append(quantity);
    if (imported) {
      sb.append(" imported");
    }
    sb.append(" ");
    sb.append(product.getDescription());
    sb.append(": ");
    sb.append(getTaxedValue());
    return sb.toString();
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public boolean isImported() {
    return imported;
  }

  public void setImported(boolean imported) {
    this.imported = imported;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public BigDecimal getTaxes() {
    BigDecimal taxes = this.value.multiply(product.getType().tax);
    if (imported) {
      taxes = taxes.add(this.value.multiply(Taxes.IMPORT_TAXES));
    }
    taxes = SalesTaxesUtils.roundTo5Cents(taxes);
    return taxes;
  }

  public BigDecimal getTaxedValue() {
    return value.add(getTaxes());
  }

}
