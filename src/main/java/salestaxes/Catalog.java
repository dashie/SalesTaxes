package salestaxes;

import java.util.HashMap;

/**
 *
 */
public final class Catalog {

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
   * 
   * @param description
   * @return
   */
  public Product find(String description) {
    return map.get(description);
  }
}
