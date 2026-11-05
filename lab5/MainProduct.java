class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class MainProduct {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Мышь", 45.0, 10);
        products[1] = new Product("Клавиатура", 120.0, 5);
        products[2] = new Product("Монитор", 650.0, 2);
        products[3] = new Product("Ноутбук", 2500.0, 3);
        products[4] = new Product("Наушники", 80.0, 4);

        Product maxPriceProduct = products[0];
        double totalCost = 0.0;

        for (int i = 0; i < products.length; i++) {
            if (products[i].price > maxPriceProduct.price) {
                maxPriceProduct = products[i];
            }
            totalCost += (products[i].price * products[i].quantity);
        }

        System.out.println("Товар с максимальной ценой: " + maxPriceProduct.name + " (" + maxPriceProduct.price + ")");
        System.out.println("Общая стоимость всех товаров: " + totalCost);
    }
}