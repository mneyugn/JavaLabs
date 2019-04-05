package lab2;

public class Item implements Comparable<Item> {
    private String nazwa;
    private double masa;
    private ItemCondition stan;
    private int ilosc;

    public Item(String nazwa, ItemCondition stan) {
        this.nazwa = nazwa;
        this.stan = stan;
    }

    public Item(String nazwa, double masa, ItemCondition stan, int ilosc) {
        this(nazwa, stan);
        this.masa = masa;
        this.ilosc = ilosc;
    }

    @Override
    public int compareTo(Item o) {
        return nazwa.compareTo(o.nazwa);
    }

    void print() {
        if (this.nazwa != null) {
            System.out.println("Nazwa: " + nazwa +
                    "\t Masa: " + masa +
                    "\t Stan: " + stan +
                    "\t Ilosc: " + ilosc);
        } else {
            System.out.println("Brak obiektu.");
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getMasa() {
        return masa;
    }

    public ItemCondition getStan() {
        return stan;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
