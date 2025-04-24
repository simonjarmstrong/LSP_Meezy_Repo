package org.howard.edu.lspfinal.question1;


 class ShoppingCartTest {

}
public class ShoppingCartTest {
	
}	
    @Test
    @DisplayName("Test for adding valid item")
    public void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 25.0);
        assertEquals(25.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    public void testAddItemWithZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Notebook", 0.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    public void testAddItemWithNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Pen", -5.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for applying 'SAVE10'")
    public void testApplySave10Discount() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test for applying 'SAVE20'")
    public void testApplySave20Discount() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test for applying invalid discount code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("INVALIDCODE");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Shirt", 30.0);
        cart.addItem("Pants", 40.0);
        assertEquals(70.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Shoes", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(90.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostWithEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost());
    }
}