package salestaxes;

import static salestaxes.Taxes.NO_TAX;
import static salestaxes.Taxes.SALES_TAX;

import java.math.BigDecimal;

/**
 *
 */
public class Product {

  private String description;

  private Type type;

  public Product() {
  }

  public Product(String description, Type type) {
    this.type = type;
    this.description = description;
  }

  @Override
  public String toString() {
    return description;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    return true;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  /**
   *
   */
  public enum Type {

    BOOK(NO_TAX),

    FOOD(NO_TAX),

    MEDICAL_PRODUCT(NO_TAX),

    OTHER(SALES_TAX);

    BigDecimal tax;

    private Type(BigDecimal tax) {
      this.tax = tax;
    }
  }
}
