package org.howard.edu.lsp.midterm.question2;

public class BookDriver {
    public static void main(String[] args) {
        // Create some Book objects (assuming you have a Book class in the same package)
        Book storyOne = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book storyTwo = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book storyThree = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Demonstrate the equals() method
        System.out.println(storyOne.equals(storyTwo));   // Expected: true
        System.out.println(storyOne.equals(storyThree)); // Expected: false

        // Demonstrate the toString() method
        System.out.println(storyOne); 
        // Example output: Title: The Great Gatsby, Author: F. Scott Fitzgerald, 
        //                 ISBN: 123456789, Year Published: 1925
    }
}
