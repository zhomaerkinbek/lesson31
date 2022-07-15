package kg.attractor.java;

import kg.attractor.java.homework.RestaurantOrders;
import kg.attractor.java.homework.domain.Item;
import kg.attractor.java.homework.domain.Order;

import java.util.Scanner;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

// используя статические imports
// мы импортируем *всё* из Collectors и Comparator.
// теперь нам доступны такие операции как
// toList(), toSet() и прочие, без указания уточняющего слова Collectors. или Comparator.
// вот так было до импорта Collectors.toList(), теперь стало просто toList()


public class Main {

    public static void main(String[] args) {
        // это для домашки
        // выберите любое количество заказов, какое вам нравится.
        //var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        //var orders = RestaurantOrders.read("orders_10_000.json").getOrders();
        var restaurant = RestaurantOrders.read("orders_100.json");

        var orders = restaurant.getOrders();
//      метод, который печатает список заказов.
//        restaurant.printOrders();
//      метод возвращающий список из N заказов имеющих наибольшую общую стоимость.
//        var maxNOrders = restaurant.returnNMaxOrders();
//        maxNOrders.forEach(Order::printOrder);
//      метод возвращающий список из N заказов, имеющих наименьшую общую стоимость.
//        var minNOrders = restaurant.returnNMinOrders();
//        minNOrders.forEach(Order::printOrder);
//      метод, который будет возвращать все заказы которые были оформлены с выдачей "на дом"
//        var homeOrders = restaurant.returnHomeOrders();
//        homeOrders.forEach(Order::printOrder);
//      заказ на дом" наиболее прибыльный
//        var minTotalHomeOrder = restaurant.returnMaxOrMinHomeOrder(false);
//        minTotalHomeOrder.printOrder();
//      заказ на дом" наиманее прибыльный
//        var maxTotalHomeOrder = restaurant.returnMaxOrMinHomeOrder(true);
//        maxTotalHomeOrder.printOrder();
//      метод, который выбирать все заказы с общей суммой больше minOrderTotal = 45, и меньше maxOrderTotal = 80.
//        var ordersBetweenMinAndMaxTotal = restaurant.getOrdersBetweenMinAndMaxTotal(45, 80);
//        ordersBetweenMinAndMaxTotal.forEach(Order::printOrder);
//      метод возвращающий общую стоимость всех заказов.
//        var totalSum = restaurant.getSumOfAllOrders();
//        System.out.println(totalSum);
//      отсортированный список уникальных адресов электронной почты для всех клиентов
//        var uniqueMails = restaurant.getUniqMails();
//        uniqueMails.forEach(System.out::println);
//      метод возвращающий список заказов, сгруппированных по имени заказчика
//        var uniqueCustomers = restaurant.getUniqueCustomers();
//        uniqueCustomers.forEach((k,v) -> {
//            k.printCustomer();
//            v.forEach(Item::printItem);
//        });
//      список уникальных заказчиков и общую сумму заказов для каждого из них
//        var uniqueCustomerAndTotalOrder = restaurant.getUniqueCustomerAndTotalOrder();
//        uniqueCustomerAndTotalOrder.forEach((k,v) -> {
//            k.printCustomer();
//            System.out.printf("Общая сумма заказов: %.2f\n", v);
//        });
//      клиент с максимальной суммой всех его заказов
//        System.out.printf("Покупатель с максимальной общей стоимостью заказов: %s\n", restaurant.getCustomerMaxTotalOrders().getFullName());
//      клиент с минимальной суммой всех его заказов
//        System.out.printf("Покупатель с минимальной общей стоимостью заказов: %s\n", restaurant.getCustomerMinTotalOrders().getFullName());
//      метод, который группирует "товары" по их общему количеству заказов
//        var itemWithCountOrder = restaurant.getItemWithCountOrder();
//        itemWithCountOrder.forEach((k, v) -> {
//            System.out.printf("Товар: %s, количество заказов этого товара: %s\n", k, v);
//        });

        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)
    }
}
