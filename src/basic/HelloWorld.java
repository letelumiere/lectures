package basic;

import java.text.DecimalFormat;
import java.util.*;

interface PaymentStrategy{
    public void pay(int amount);
}

class KAKAOCardStrategy implements PaymentStrategy{
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public KAKAOCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using KAKAOCard.");
    }

}

class LUNACardStrategy implements PaymentStrategy{
    private String emailId;
    private String password;
    
    public LUNACardStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using LUNACard.");
    }
}

class Item{
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class ShoppingCart{
    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotal(){
        int sum = 0;
        for(Item item:items){
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item A = new Item("KundolA", 100);
        Item B = new Item("KundolB", 100);
        
        cart.addItem(A);
        cart.addItem(B);

        //pay by LUNACard
        cart.pay(new LUNACardStrategy("Kundol@example.com", "11212"));

        //pay by KAKAOCard
        cart.pay(new KAKAOCardStrategy("ju hon", "12312345", "112312", "12/02"));
    }
}

/*400 paid using LUNACARD
/*400 paid using KAKAOCard */

