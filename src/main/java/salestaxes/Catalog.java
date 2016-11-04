package salestaxes;

import java.util.HashMap;
import java.util.Objects;

/**
 * The products catalog.
 */
public final class Catalog {

  /**
   * Singleton instance of the product catalog.
   */
  public static final Catalog SINGLETON = new Catalog();

  private HashMap<String, Product> map = new HashMap<>();

  /**
   * 
   */
  private Catalog() {

    add("book", Product.Type.BOOK);
    add("chocolate bar", Product.Type.FOOD);
    add("box of chocolates", Product.Type.FOOD);
    add("packet of headache pills", Product.Type.MEDICAL_PRODUCT);
    add("music CD", Product.Type.OTHER);
    add("bottle of perfume", Product.Type.OTHER);
  }

  /**
   * 
   * @param description
   * @param type
   */
  private void add(String description, Product.Type type) {

    Product p = new Product(description, type);
    map.put(description, p);
  }

  /**
   * Returns a {@link Product} from its name.
   * 
   * @param name
   * @return
   */
  public Product find(String name) {

    Objects.requireNonNull(name, "name");
    Product p = map.get(name);
    if (p == null) {
      // TODO throw proper exception
      throw new IllegalArgumentException("name");
    }
    return p;
  }
}
