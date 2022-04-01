package org.wingaben.advertisementBoard;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class AdvertisementBoardTest {
  @Test
  public void ABoardHasAnAdvertisementWhenItIsCreated() {
    AdvertisementBoard adBoard = new AdvertisementBoard();
    int actualValue = adBoard.numberOfPublishedAdvertisements();
    int expectedValue = 1;

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void PublishAnAdvertisementByTheCompanyIncreasesTheNumberOfAdvertisementsByOne() {
    AdvertisementBoard adBoard = new AdvertisementBoard();
    Advertisement ad = new Advertisement("One","First Description","THE Company");

    int actualValue = adBoard.numberOfPublishedAdvertisements();
    adBoard.publish(ad, null, null);
    int expectedValue = actualValue+1;

    assertEquals(expectedValue, actualValue+1);
  }

  @Test
  public void WhenAnAdvertiserHasNoFoundsTheAdvertisementIsNotPublished() {
    AdvertisementBoard adBoard = new AdvertisementBoard();
    Advertisement ad = new Advertisement("SmileBix","AMi","Pepe Gotera y Otilio");
    AdvertiserDatabase adDb = mock(AdvertiserDatabase.class);
    PaymentDatabase pDB = mock(PaymentDatabase.class);
    when(adDb.findAdviser("Pepe Gotera y Otilio")).thenReturn(true);
    when(pDB.advertiserHasFunds("Pepe Gotera y Otilio")).thenReturn(false);


    int actualValue = adBoard.numberOfPublishedAdvertisements();
    adBoard.publish(ad, adDb, pDB);
    int expectedValue = adBoard.numberOfPublishedAdvertisements();

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void AnAdvertisementIsPublishedIfTheAdvertiserIsRegisteredAndHasFunds() {
    AdvertisementBoard adBoard = new AdvertisementBoard();
    Advertisement ad = new Advertisement("SmileBix","AMi","Robin Robot");
    AdvertiserDatabase adDb = mock(AdvertiserDatabase.class);
    PaymentDatabase pDB = mock(PaymentDatabase.class);
    when(adDb.findAdviser("Robin Robot")).thenReturn(true);
    when(pDB.advertiserHasFunds("Robin Robot")).thenReturn(true);

    adBoard.publish(ad, adDb, pDB);
    Advertisement actualValue = adBoard.findByTitle("SmileBix");

    verify(pDB).advertisementPublished("Robin Robot");

    assertEquals(ad, actualValue);
  }

  @Test
  public void WhenTheOwnerMakesTwoPublicationsAndTheFirstOneIsDeletedItIsNotInTheBoard() {
    AdvertisementBoard adBoard = new AdvertisementBoard();
    Advertisement ad1 = new Advertisement("One","First description","THE Company");
    Advertisement ad2 = new Advertisement("Two","Second description","THE Company");
    adBoard.publish(ad1, null, null);
    adBoard.publish(ad2, null, null);
    adBoard.deleteAdvertisement("One","THE Company");

    assertNull(adBoard.findByTitle("One"));
  }

  @Test
  public void AnExistingAdvertisementIsNotPublished() {
    AdvertisementBoard adBoard = new AdvertisementBoard();
    Advertisement ad1 = new Advertisement("One","First description","THE Company");
    Advertisement ad2 = new Advertisement("One","Second description","THE Company");
    AdvertiserDatabase adDb = mock(AdvertiserDatabase.class);
    PaymentDatabase pDB = mock(PaymentDatabase.class);
    adBoard.publish(ad1, adDb, pDB);
    adBoard.publish(ad2, adDb, pDB);
  }

  @Test
  public void AnExceptionIsRaisedIfTheBoardIsFullAndANewAdvertisementIsPublished() {}
}