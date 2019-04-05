package lab2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        FulfillmentCenterContainer container = new FulfillmentCenterContainer();

        //addCenter()
        container.addCenter("magazyn1", 500);
        container.addCenter("magazyn2", 300);
        container.addCenter("magazyn3", 400);
        container.addCenter("magazyn4", 600);

        container.getMagazyny()
                .get("magazyn2")
                .addProduct(new Item("Plecak", 12, ItemCondition.NEW, 15));

        container.getMagazyny()
                .get("magazyn3")
                .addProduct(new Item("Butelka", 12, ItemCondition.NEW, 15));


        System.out.println("Wszystkie magazyny: ");
        container.summary();


        //findEmpty()
        System.out.println("Puste magazyny: ");
        List<FulfillmentCenter> emptyCenters = new LinkedList<>(container.findEmpty());
        for (FulfillmentCenter emptyCenter : emptyCenters) {
            emptyCenter.summary();
        }

//        removeCenter()
        System.out.println("\n------------------------------------- \n\tLista magazynów po usunięciu magazyn4 ");
        container.removeCenter("magazyn4");
        container.summary();


        System.out.println("------------------------------------- \n");
        FulfillmentCenter center = new FulfillmentCenter("MAGAZYN", 230);
        Item przedmiot4 = new Item("przedmiot4", 6, ItemCondition.NEW, 20);

        center.addProduct(new Item("Butelka", 5, ItemCondition.NEW, 11));
        center.addProduct(new Item("Piłka", 4, ItemCondition.REFURBISHED, 5));
        center.addProduct(new Item("Zegarek", 5, ItemCondition.USED, 4));
        center.addProduct(new Item("Zegarek", 4, ItemCondition.NEW, 4));
        center.addProduct(new Item("Przedmiot", 3, ItemCondition.USED, 7));
        center.addProduct(new Item("Przedmiot3", 5, ItemCondition.REFURBISHED, 8));
        center.addProduct(new Item("Przedmiot2", 3, ItemCondition.USED, 14));
        center.addProduct(przedmiot4);

        center.summary();
        System.out.println("Pojemność magazynu: " + center.getPojemnosc());
        System.out.println("Oblozenie magazynu: " + center.getOblozenie());


        System.out.println("------------------------------------- \n");
        System.out.println("\t search() - Zegarek, NEW ");
        Item item1 = center.search("Zegarek", ItemCondition.NEW);
        item1.print();


        System.out.println("------------------------------------- \n \tgetProduct() - Zegarek, NEW");
        Item item2 = new Item("Zegarek", ItemCondition.NEW);
        center.getProduct(item2);
        center.summary();

        System.out.println("------------------------------------- \n \tcountByCondition(NEW)");
        int couterNew = center.countByCondition(ItemCondition.NEW);
        System.out.println(couterNew);

        System.out.println("------------------------------------- \n \tsortByName() ");
        List<Item> sortByNameCenter = center.sortByName();
        sortByNameCenter.forEach(item -> item.print());

        System.out.println("------------------------------------- \n \tsortByAmount() ");
        List<Item> sortByAmountCenter = center.sortByAmount();
        sortByAmountCenter.forEach(item -> item.print());

        System.out.println("------------------------------------- \n \tmax() ");
        Item i1 = center.max();
        i1.print();

        System.out.println("------------------------------------- \n \tsearchPartial(Przed) ");
        List<Item> searchPartialItemList = center.searchPartial("Przed");
        searchPartialItemList.forEach(item -> item.print());

        System.out.println("------------------------------------- \n \tremoveProduct(przedmiot4)");
        center.removeProduct(przedmiot4);
        center.summary();


//        lista.forEach(item -> item.print());
    }
}

