package kg.attractor.java.homework.domain;

import kg.attractor.java.homework.util.NotImplementedException;

import java.util.List;
import java.util.Objects;

public class Order {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private final Customer customer;
    private final List<Item> items;
    private final boolean homeDelivery;
    private transient double total = 0.0d;

    public Order(Customer customer, List<Item> orderedItems, boolean homeDelivery) {
        this.customer = customer;
        this.items = List.copyOf(orderedItems);
        this.homeDelivery = homeDelivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return homeDelivery == order.homeDelivery &&
                Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, homeDelivery);
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isHomeDelivery() {
        return homeDelivery;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!

    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------

    public void calculateTotal() {
        total = items.stream()
                .mapToDouble(e -> e.getAmount() * e.getPrice()).sum();
    }

    public void printOrder(){
        System.out.println("---------------------------------------------------");
        System.out.printf("Покупатель: %s\n", customer.getFullName());
        items.forEach(Item::printItem);
        System.out.printf("Доставка на дом: %s\n", isHomeDelivery() ? "да" : "нет");
        System.out.printf("Общая сумма: $%.2f\n", total);

    }
}
