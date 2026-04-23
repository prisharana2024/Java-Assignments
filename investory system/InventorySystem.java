import java.util.*;

interface Product {
    void displayDetails();
}

class LegacyItem {
    private int itemId;
    private String description;

    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    public void print() {
        System.out.println("Legacy Item -> ID: " + itemId + ", Description: " + description);
    }
}

class ProductAdapter implements Product {
    private LegacyItem legacyItem;

    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    public void displayDetails() {
        System.out.print("[LEGACY PRODUCT] ");
        legacyItem.print();
    }
}

class NewProduct implements Product {
    private String name;

    public NewProduct(String name) {
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("[NEW PRODUCT] Name: " + name);
    }
}

class InventoryManager {
    private static InventoryManager instance;
    private List<Product> productList;

    private InventoryManager() {
        productList = new ArrayList<>();
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Iterator<Product> returnInventory() {
        return productList.iterator();
    }

    public int getTotalProducts() {
        return productList.size();
    }
}

public class InventorySystem {
    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("   INVENTORY MANAGEMENT SYSTEM   ");
        System.out.println("==================================");

        InventoryManager manager = InventoryManager.getInstance();

        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Phone"));

        LegacyItem old1 = new LegacyItem(101, "Old Keyboard");
        LegacyItem old2 = new LegacyItem(102, "Old Mouse");

        manager.addProduct(new ProductAdapter(old1));
        manager.addProduct(new ProductAdapter(old2));

        System.out.println("\n--- Inventory Items ---");

        Iterator<Product> iterator = manager.returnInventory();
        int count = 1;

        while (iterator.hasNext()) {
            System.out.print(count + ". ");
            Product p = iterator.next();
            p.displayDetails();
            count++;
        }

        System.out.println("\nTotal Products in Inventory: " + manager.getTotalProducts());
        System.out.println("Generated on: " + new Date());

        System.out.println("==================================");
        System.out.println("   END OF INVENTORY DISPLAY   ");
        System.out.println("==================================");
    }
}