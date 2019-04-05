package lab2;

public enum ItemCondition {
    NEW(1), USED(2), REFURBISHED(3);

    private int index;

    ItemCondition(int index) {
        this.index = index;
    }
}

