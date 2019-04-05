
public class Function {

    private String name;
    private String keyWord;

    public Function(String name, String keyWord) {
        this.name = name;
        this.keyWord = keyWord;
    }

    public String getName() {
        return name;
    }

    public String getKeyWord() {
        return keyWord;
    }

    @Override
    public String toString() {
        return name;
    }
}
