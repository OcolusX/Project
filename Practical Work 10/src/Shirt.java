public class Shirt {
    private String id;
    private String name;
    private String color;
    private String size;

    // Разбиваем полученную строку по словам с помощью метода split и запихиваем каждое слово в соответствующее поле
    public Shirt(String shirt) {
        String[] split = shirt.split(",");
        id = split[0];
        name = split[1];
        color = split[2];
        size = split[3];
    }

    @Override
    public String toString() {
        return "\tid = " + id + "\n\tname = " + name + "\n\tcolor = " + color + "\n\tsize = " + size + "\n\t";
    }
}
