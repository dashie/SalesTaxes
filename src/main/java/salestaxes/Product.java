package salestaxes;

import static salestaxes.Consts.NO_TAX;
import static salestaxes.Consts.SALES_TAX;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 */
public class Product {

  private String name;

  private Type type;

  public Product() {
  }

  public Product(String name, Type type) {
    Objects.requireNonNull(name, "name");
    Objects.requireNonNull(type, "type");
    this.type = type;
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
