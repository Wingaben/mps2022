package org.wingaben.advertisementBoard;

/**
 * @author Antonio J. Nebro
 */
public interface PaymentDatabase {
  void advertisementPublished(String advertiserName);
  boolean advertiserHasFunds(String advertiserName);
}
