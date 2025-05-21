import java.util.Vector;

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

public class OnlineShoppingManager {
    private Vector<Product> inventory;

    public OnlineShoppingManager() {
        inventory = new Vector<>();
    }

    public void addProduct(String name, double price, String category) {
        Product product = new Product(name, price, category);
        inventory.add(product);
    }

    public void removeProduct(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).name.equalsIgnoreCase(name)) {
                inventory.remove(i);
                break;
            }
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : inventory) {
            System.out.println("Name: " + product.name + ", Price: " + product.price + ", Category: " + product.category);
        }
    }

    public static void main(String[] args) {
        OnlineShoppingManager manager = new OnlineShoppingManager();

        // Add some products to the inventory
        manager.addProduct("Laptop", 40000, "Electronics");
        manager.addProduct("T-shirt", 550, "Clothing");
        manager.addProduct("Book", 920, "Books");

        // Display all products in the inventory
        manager.displayInventory();

        // Remove a product
        manager.removeProduct("Book");

        // Display updated inventory
        manager.displayInventory();

        // Remove another product
        manager.removeProduct("Laptop");

        // Display updated inventory
        manager.displayInventory();
    }
}


Inventory:
Name: Laptop, Price: 40000.0, Category: Electronics
Name: T-shirt, Price: 550.0, Category: Clothing
Name: Book, Price: 920.0, Category: Books
Inventory:
Name: Laptop, Price: 40000.0, Category: Electronics
Name: T-shirt, Price: 550.0, Category: Clothing
Inventory:
Name: T-shirt, Price: 550.0, Category: Clothing
