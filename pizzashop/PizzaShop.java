import java.util.ArrayList;

enum PizzaType {
    veg,
    nonveg
}

enum PizzaSize {
    small,
    medium,
    large
}

class Pizza {
    private PizzaSize size;
    private PizzaType type;
    public PizzaSize getSize() {
        return size;
    }


    public void setSize(PizzaSize size) {
        this.size = size;
    }


    public PizzaType getType() {
        return type;
    }


    public void setType(PizzaType type) {
        this.type = type;
    }


    public Pizza(PizzaSize size, PizzaType type) {
        this.size = size;
        this.type = type;
    }


    private int price;


    public int getPrice() {
        int price = 0;
        if (this.type == PizzaType.veg) {
            if (this.size == PizzaSize.small) {
                price = 100;
            } else if (this.size == PizzaSize.medium) {
                price = 200;
            } else if (this.size == PizzaSize.large) {
                price = 300;
            }
        } else {
            if (this.size == PizzaSize.small) {
                price = 150;
            } else if (this.size == PizzaSize.medium) {
                price = 250;
            } else if (this.size == PizzaSize.large) {
                price = 350;
            }
        }
        this.price = price;
        return this.price;
    }

}

class CartItem {
    private Pizza pizza;
    private int quantity;

    public CartItem(Pizza pizza, int quantity) {
        this.setPizza(pizza);
        this.setQuantity(quantity);
        this.setAmount(pizza.getPrice() * quantity);
    }

    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}

class Cart {
    private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    private int totalAmount=0;
    private int totalQuantity=0;
    
    public int getTotalAmount() {
        return totalAmount;
    }

   
    public int getTotalQuantity() {
        return totalQuantity;
    }

    //action

    public void addCartItem(CartItem cartItem)
    {
        this.cartItems.add(cartItem);
        this.calculate();
    }

    private void calculate()
    {
        int totalAmount=0;
        int totalQuantity=0;
        for (CartItem cartItem : cartItems) {
            totalQuantity+=cartItem.getQuantity();
            totalAmount+=cartItem.getAmount();
        }
        this.totalAmount=totalAmount;
        this.totalQuantity=totalQuantity;
    }

    public void checkout() {
        System.out.println("****** Invoice ********");
        for (CartItem cartItem : cartItems) {
            System.out.println("Pizza " + cartItem.getPizza().getType() + " ("+cartItem.getPizza().getSize()+") | " +cartItem.getPizza().getPrice() + " | " +cartItem.getQuantity() + " | " +cartItem.getAmount());
        }
        System.out.println("****** Invoice ********");
        System.out.println("total quantity " + this.getTotalQuantity());
        System.out.println("total amount " + this.getTotalAmount());
    }
}

class PizzaShop {

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza(PizzaSize.small, PizzaType.nonveg);
        Pizza pizza2 = new Pizza(PizzaSize.large, PizzaType.veg);
        CartItem  cartItem1 = new CartItem(pizza1, 2);
        CartItem  cartItem2 = new CartItem(pizza2, 1);
        Cart cart =new Cart();
        cart.addCartItem(cartItem1);
        cart.addCartItem(cartItem2);
        cart.checkout();
    }
}
