import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String flat;
    private String d;

    // Суть обоих конструкторов заключается в последовательном добавлении слов из строки в соответствующие поля

    // Конструктор, использующий tokenizer (просто заводим переменную Tokenizer и переходим к следующему слову из строки
    // address при помощи метода nextToken()), причём d - символ разделения слов в строке
    public Address(String address, String d) {
        this.d = d;
        StringTokenizer tokenizer = new StringTokenizer(address, d);
        country = tokenizer.nextToken().trim();
        region = tokenizer.nextToken().trim();
        city = tokenizer.nextToken().trim();
        street = tokenizer.nextToken().trim();
        house = tokenizer.nextToken().trim();
        building = tokenizer.nextToken().trim();
        flat = tokenizer.nextToken().trim();
    }

    // Конструктор, использующий метод разбиения слов split()
    public Address(String address) {
        String[] split = address.split(",");
        country = split[0].trim();
        region = split[1].trim();
        city = split[2].trim();
        street = split[3].trim();
        house = split[4].trim();
        building = split[5].trim();
        flat = split[6].trim();
    }

    public String getAddress() {
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s", country, region, city, street, house, building, flat);
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getBuilding() {
        return building;
    }

    public String getFlat() {
        return flat;
    }

}
