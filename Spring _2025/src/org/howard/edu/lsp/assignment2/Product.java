package org.howard.edu.lsp.assignment2;

public class Product {
    private int productId;
    private String name;
    private double price;
    private String category;
    private String priceRange;

    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = ""; 
    }

    
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPriceRange() { return priceRange; }
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }

    @Override
    public String toString() {
        return productId + "," + name + "," + price + "," + category + "," + priceRange;
    }
}

