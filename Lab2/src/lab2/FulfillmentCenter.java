package lab2;

import java.util.*;

public class FulfillmentCenter {
    private String nazwaMagazynu;
    private List<Item> lista;
    private double pojemnosc;
    private double oblozenie;

    public FulfillmentCenter(String nazwaMagazynu, double pojemnosc) {
        this.nazwaMagazynu = nazwaMagazynu;
        this.pojemnosc = pojemnosc;
        lista = new LinkedList<>();
        oblozenie = 0;
    }

    void addProduct(Item item) {
        if (pojemnosc >= (oblozenie + item.getMasa() * item.getIlosc())) {
            Item foundItem = search(item.getNazwa(), item.getStan());
            if (foundItem.getNazwa() == null) {
                lista.add(item);
            } else {
                foundItem.setIlosc(item.getIlosc() + foundItem.getIlosc());
            }
            oblozenie += item.getIlosc() * item.getMasa();
        } else System.err.println("Brak miejsca w magazynie dla " + item.getNazwa());
    }

    public void getProduct(Item item) {
        Item foundItem = search(item.getNazwa(), item.getStan());
        if (foundItem.getIlosc() == 1) {
            removeProduct(item);
        } else {
            foundItem.setIlosc(foundItem.getIlosc() - 1);
        }
    }

    boolean removeProduct(Item item) {
        return lista.remove(item);
    }

//    public Item search2(String s) {
//        for (Item item : lista) {
//            if (item.nazwa.equals(s)) {
//                return item;
//            }
//        }
//        return new Item(null);
//    }

    //  search using Comparator
    public Item search(String s, ItemCondition condition) { //
        List<Item> lista2 = new LinkedList<>(lista);
        Comparator<Item> c = new NameAndConditionComparator();
        Collections.sort(lista2, c);
        int index = Collections.binarySearch(lista2, new Item(s, condition), c);
        if (index < 0) {
            return new Item(null, null);
        } else {
            return lista2.get(index);
        }
    }


    public List<Item> searchPartial(String s) {
        List<Item> foundProducts = new LinkedList<>();
        for (Item item : lista) {
            if (item.getNazwa().contains(s)) {
                foundProducts.add(item);
            }
        }
        return foundProducts;
    }

    int countByCondition(ItemCondition condition) {
        int amountOfProducts = 0;
        for (Item i : lista) {
            if (i.getStan().equals(condition)) {
                amountOfProducts += i.getIlosc();
            }
        }
        return amountOfProducts;
    }

    public void summary() {
        System.out.println(nazwaMagazynu);
        for (Item item : lista) {
            item.print();
        }
    }

    public List<Item> sortByName() {
        List<Item> lista2 = new LinkedList<>(lista);
        Collections.sort(lista2);
        return lista2;
    }

    public List<Item> sortByAmount() {
        List<Item> lista2 = new LinkedList<>(lista);
        Collections.sort(lista2, Collections.reverseOrder(new AmountComparator()));
        return lista2;
    }

    public Item max() {
        return Collections.max(lista, new AmountComparator());
    }


    public double getPojemnosc() {
        return pojemnosc;
    }

    public double getOblozenie() {
        return oblozenie;
    }


    class AmountComparator implements Comparator<Item> {
        @Override
        public int compare(Item i1, Item i2) {
            return i1.getIlosc() - i2.getIlosc();
        }
    }

    class NameAndConditionComparator implements Comparator<Item> {
        @Override
        public int compare(Item i1, Item i2) {
            int i = i1.getNazwa().toLowerCase().compareTo(i2.getNazwa().toLowerCase());
            if (i == 0) {
                return i1.getStan().compareTo(i2.getStan());
            } else {
                return i;
            }
        }
    }
}
