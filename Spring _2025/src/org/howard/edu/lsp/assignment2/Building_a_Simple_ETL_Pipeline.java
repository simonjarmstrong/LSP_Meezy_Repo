package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Building_a_Simple_ETL_Pipeline {

    private static final String INPUT_FILE = "data/products.csv";
    private static final String OUTPUT_FILE = "data/transformed_products.csv";

    public static void main(String[] args) {
        try {
            List<Product> products = extract(INPUT_FILE);
            transform(products);
            load(products, OUTPUT_FILE);
            System.out.println("ETL Pipeline executed successfully. Check the transformed file.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Extract data from the CSV file and parse it into Product objects.
     */
    private static List<Product> extract(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        Path path = Paths.get(filePath);
        
        if (!Files.exists(path)) {
            throw new FileNotFoundException("Error: Input file not found at " + filePath);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length == 4) { // Ensure correct format
                    int productId = Integer.parseInt(values[0].trim());
                    String name = values[1].trim();
                    double price = Double.parseDouble(values[2].trim());
                    String category = values[3].trim();
                    products.add(new Product(productId, name, price, category));
                }
            }
        }
        return products;
    }

    /**
     * Transform data: apply rules to modify product details.
     */
    private static void transform(List<Product> products) {
        for (Product product : products) {
            // Convert product name to uppercase
            product.setName(product.getName().toUpperCase());

            // Apply 10% discount to Electronics
            if (product.getCategory().equalsIgnoreCase("Electronics")) {
                double discountedPrice = product.getPrice() * 0.90; // 10% discount
                product.setPrice(Math.round(discountedPrice * 100.0) / 100.0); // Round to 2 decimal places
            }

            // Update category for premium products
            if (product.getPrice() > 500) {
                product.setCategory("Premium Electronics");
            }

            // Assign price range
            double price = product.getPrice();
            if (price <= 10) {
                product.setPriceRange("Low");
            } else if (price <= 100) {
                product.setPriceRange("Medium");
            } else if (price <= 500) {
                product.setPriceRange("High");
            } else {
                product.setPriceRange("Premium");
            }
        }
    }

    /**
     * Load the transformed data into a new CSV file.
     */
    private static void load(List<Product> products, String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ProductID,Name,Price,Category,PriceRange\n"); // Write header
            for (Product product : products) {
                bw.write(String.format("%d,%s,%.2f,%s,%s\n",
                        product.getProductId(), product.getName(), product.getPrice(),
                        product.getCategory(), product.getPriceRange()));
            }
        }
    }
}
