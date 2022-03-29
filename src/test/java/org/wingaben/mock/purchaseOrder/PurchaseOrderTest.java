package org.wingaben.mock.purchaseOrder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PurchaseOrderTest {

    @Test
    public void shouldPurchaseWorkProperlyWhenThereAreEnoughProducts() {
        // STEP 1: create mock object
        Warehouse warehouse = Mockito.mock(Warehouse.class) ;

        // STEP 2: define behavior
        Mockito.when(warehouse.thereAreProducts("Beer", 20)).thenReturn(true) ;

        // STEP 3: execute
        PurchaseOrder purchaseOrder = new PurchaseOrder("Beer", 20) ;
        purchaseOrder.purchase(warehouse);

        // STEP 4: verify
        Mockito.verify(warehouse).remove("Beer", 20);
        Mockito.verify(warehouse, Mockito.times(1)).remove("Beer", 20);
    }

    @Test
    public void shouldPurchaseWorkProperlyWhenThereAreNotEnoughProducts() {
        // STEP 1: create mock object
        Warehouse warehouse = Mockito.mock(Warehouse.class) ;

        // STEP 2: define behavior
        Mockito.when(warehouse.thereAreProducts("Beer", 20)).thenReturn(false) ;

        // STEP 3: execute
        PurchaseOrder purchaseOrder = new PurchaseOrder("Beer", 20) ;
        purchaseOrder.purchase(warehouse);

        // STEP 4: verify
        Mockito.verify(warehouse, Mockito.never()).remove("Beer", 20);
    }
}