package lab2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FulfillmentCenterContainer {
    private Map<String, FulfillmentCenter> magazyny;

    public FulfillmentCenterContainer() {
        this.magazyny = new HashMap<>();
    }

    public void addCenter(String nazwaMagazynu, double pojemnosc) {
        magazyny.putIfAbsent(nazwaMagazynu, new FulfillmentCenter(nazwaMagazynu, pojemnosc));
    }

    public void removeCenter(String nazwaMagazynu) {
        magazyny.remove(nazwaMagazynu);
    }

    public List<FulfillmentCenter> findEmpty() {
        List<FulfillmentCenter> emptyCenters = new LinkedList<>();
        for (Map.Entry<String, FulfillmentCenter> i : magazyny.entrySet()) {
            if (i.getValue().getOblozenie() == 0) {
                emptyCenters.add(i.getValue());
            }
        }
        return emptyCenters;
    }

    public void summary() {
        for (Map.Entry<String, FulfillmentCenter> i : magazyny.entrySet()) {
            double zapelnienie = i.getValue().getOblozenie() / i.getValue().getPojemnosc() * 100;
            System.out.println("Nazwa magazynu: " + i.getKey());
            System.out.print("\tZapelnienie: " + zapelnienie + "% \n");
        }
    }

    public Map<String, FulfillmentCenter> getMagazyny() {
        return magazyny;
    }

}

