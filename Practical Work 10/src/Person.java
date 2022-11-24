public class Person {

    private String secondName;
    private String name;
    private String thirdName;

    public Person(String secondName, String name, String thirdName) {
        this.secondName = secondName;
        this.name = name;
        this.thirdName = thirdName;
    }

    // Метод возвращает ФИО, проверяя заполнены ли соответствующие поля. Возможные варианты:
    // - Фамилия имя отчество;
    // - Фамилия имя;
    // - Имя;
    // - Имя + отчество
    public String getPerson() {
        String person = "";
        if(secondName != null) {
            person += secondName + " ";
        }
        if(name != null) {
            person += name;
            if(!name.isEmpty() && thirdName != null) {
                person += " " + thirdName;
            }
        }
        return person;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }
}
