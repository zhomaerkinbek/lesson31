package kg.attractor.java.homework;

import com.google.gson.Gson;
import kg.attractor.java.homework.domain.Customer;
import kg.attractor.java.homework.domain.Item;
import kg.attractor.java.homework.domain.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class RestaurantOrders {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private List<Order> orders;

    private RestaurantOrders(String fileName) {
        var filePath = Path.of("data", fileName);
        Gson gson = new Gson();
        try {
            orders = List.of(gson.fromJson(Files.readString(filePath), Order[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RestaurantOrders read(String fileName) {
        var ro = new RestaurantOrders(fileName);
        ro.getOrders().forEach(Order::calculateTotal);
        return ro;
    }

    public List<Order> getOrders() {
        return orders;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!

    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------

    // Наполните этот класс решением домашнего задания.
    // Вам необходимо создать все необходимые методы
    // для решения заданий из домашки :)
    // вы можете добавлять все необходимые imports
    //
    public void printOrders(){
        orders.forEach(Order::printOrder);
    }

    public List<Order> getNMaxOrders(){
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            try{
                System.out.print("Введите число N, чтобы увидеть N количество заказов имеющих наибольшую общую стоимость. N: ");
                n = tryParse(sc.nextLine());
            } catch (Exception e){
                System.out.println("Введите число!");
                continue;
            }
            break;

        }
        return orders.stream()
                .sorted(comparingDouble(Order::getTotal).reversed())
                .limit(n)
                .collect(toList());
    }

    public List<Order> getNMinOrders(){
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            try{
                System.out.print("Введите число N, чтобы увидеть N количество заказов имеющих наименьшую общую стоимость. N: ");
                n = tryParse(sc.nextLine());
            } catch (Exception e){
                System.out.println("Введите число!");
                continue;
            }
            break;

        }
        return orders.stream()
                .sorted(comparingDouble(Order::getTotal))
                .limit(n)
                .collect(toList());
    }
    public List<Order> getHomeOrders(){
        return orders.stream()
                .filter(Order::isHomeDelivery)
                .collect(toList());
    }

    public Order getMaxOrMinHomeOrder(boolean max){
        if(max){
            return getHomeOrders().stream()
                    .max(comparingDouble(Order::getTotal))
                    .get();
        }else {
            return getHomeOrders().stream()
                    .min(comparingDouble(Order::getTotal))
                    .get();
        }
    }

    public List<Order> getOrdersBetweenMinAndMaxTotal(double minOrderTotal, double maxOrderTotal){
        return orders.stream()
                .sorted(comparingDouble(Order::getTotal))
                .dropWhile(total -> total.getTotal() < minOrderTotal)
                .takeWhile(total -> total.getTotal() <= maxOrderTotal)
                .collect(toList());
    }
    public double getSumOfAllOrders(){
        return orders.stream()
                .mapToDouble(Order::getTotal)
                .sum();
    }
    public Collection<String> getUniqMails(){
        return orders.stream()
                .map(order -> order.getCustomer().getEmail())
                .collect(toCollection(TreeSet::new));
    }

    public Map<Customer, List<Item>> getUniqueCustomers(){
        return orders.stream()
                .collect(groupingBy(Order::getCustomer, flatMapping(order -> order.getItems().stream(),
                        toList())));
    }
    public Map<Customer, Double> getUniqueCustomerAndTotalOrder(){
        return orders.stream()
                .collect(groupingBy(Order::getCustomer, summingDouble(Order::getTotal)));
    }

    public Customer getCustomerMaxTotalOrders(){
        return getUniqueCustomerAndTotalOrder().entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }

    public Customer getCustomerMinTotalOrders(){
        return getUniqueCustomerAndTotalOrder().entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }
    public Map<String, Long> getItemWithCountOrder(){
        return orders.stream()
                .flatMap(e -> e.getItems().stream())
                .collect(groupingBy(Item::getName, counting()));
    }
    public int tryParse(String str){
        return Integer.parseInt(str);
    }



}
