package org.wingaben.mock.purchaseOrder;

public interface Warehouse {
  boolean thereAreProducts(String name, int amount) ;
  void remove(String name, int amount) ;
}
