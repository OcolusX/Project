import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        task_6();

    }

    /**
     * charAt() - возвращает символ из строки по индексу
     * endsWith() - проверяет, оканчивается ли данная строка переданной в качестве параметра подстрокой
     * startsWith() - проверяет, начинается ли данная строка переданной в качестве параметра подстрокой
     * contains() - проверяет, содержится ли в строке переданная в качестве параметра подстрока
     * replaceAll() - заменяет все символы строки regex на символы replacement
     * toUpperCase() - приводит все символы к верхнему регистру
     * toLowerCase - приводит все символы к нижнему регистру
     * replaceFirst() - заменяет первое вхождение подстроки regex на строку replacement
     */
    private static void task_1(String str) {
        System.out.println("Последний символ:\t\t\t\t\t" + str.charAt(str.length() - 1));
        System.out.println("Оканчивается ли подстрокой \"!!!\"?\t" + str.endsWith("!!!"));
        System.out.println("Начинается ли подстрокой \"I like\"?\t" + str.startsWith("I like"));
        System.out.println("Содержит ли подстроку \"Java\"?\t\t" + str.contains("Java"));
        System.out.println("Заменяем символы \"a\" на \"o\":\t\t" + str.replaceAll("a", "o"));
        System.out.println("Преобразуем к верхнему регистру:\t" + str.toUpperCase());
        System.out.println("Преобразуем к нижнему регистру:\t\t" + str.toLowerCase());
        System.out.println("Вырезаем строку \"Java\":\t\t\t\t" + str.replaceFirst("Java", ""));
    }

    private static void task_2() {
        // Заводим человека и передаём ФИО в конструктор
        Person person = new Person("Мельчаков", "Дмитрий", "Сергеевич");
        System.out.println(person.getPerson()); // Печатаем ФИО
        person.setSecondName(null); // Стираем фамилию и снова печатаем ФИО
        System.out.println(person.getPerson());
        person.setThirdName(""); // Стираем отчество и снова печатаем ФИО
        System.out.println(person.getPerson());
    }

    private static void task_3() {
        // Создаём переменную типа Address помощью конструктора, использующего метод split()
        Address address = new Address("Россия, Московская область, Домодедово, Каширское шоссе, 65, 1, 39");
        System.out.println(address.getAddress() + "\n\n");

        // Создаём переменную типа Address помощью конструктора, использующего tokenizer
        address = new Address("Россия.Московская область.Домодедово.Каширское шоссе.65.1.39", ".");
        System.out.println(address.getAddress() + "\n\n");
    }

    private static void task_4() {
        // Создаём массив строк по заданию
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };

        // Создаём массив футболок и заполняем его
        Shirt[] s = new Shirt[shirts.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = new Shirt(shirts[i]);    // Конструктор разбивает строку на слова с помощью метода split()
            System.out.println("Shirt " + i + ":\n" + s[i]);
        }
    }

    private static void task_5() {
        // Создаём два формата номера: с +7... и с 8...
        PhoneNumber phoneNumber = new PhoneNumber("+71112223333");
        System.out.println(phoneNumber);
        phoneNumber = new PhoneNumber("81112223333");
        System.out.println(phoneNumber);
    }


    /** Общая стратегия алгоритма:
     * Получаем в качестве параметра строку со словами из файла и формируем из неё список слов;
     * Будем искать в списке такое слово, первый символ которого совпадает с последним символом последнего слова в
     * StringBuilder. Если нашли такое слово, то добавляем его в StringBuilder, иначе добавляем первое слово из списка
     * и продолжаем алгоритм. При этом при добавлении мы будем удалять данное слово из списка, чтобы продолжать алгоритм
     * до тех пор, пока список не пуст.
     */
    private static String getLine(String s) {
        // Приводим все символы строки к нижнему регистру (чтобы игнорировать заглавные буквы) с помощью метода
        // toLowerCase() и разбиваем строку по словам с помощью метода split(); Затем запихиваем полученный массив слов
        // в связный список с помощью метода List.of()
        List<String> list = new LinkedList<>(List.of(s.toLowerCase().split("\\s")));
        // Создаём StringBuilder (по заданию) и пихаем в него первое слово из списка с помощью метода remove()
        // P.S.: метод remove() удаляет слово из списка и возвращает это слово, поэтому в StringBuilder мы добавим
        // удалённое из списка слово
        StringBuilder builder = new StringBuilder(list.remove(0));

        // Пока список слов не пустой (метод isEmpty() возвращает true, если список пуст)
        while (!list.isEmpty()) {
            // Заводим переменную isAppend, которая будет отвечать за то, добавляли ли мы в последующем цикле for слово
            // из списка. Если не добавляли, то это значит, что в списке нет подходящего по заданию слова,
            // и мы просто должны добавить первое слово из списка, чтобы продолжить алгоритм;
            boolean isAppend = false;
            // Берём последний символ последнего слова из StringBuilder при помощи метода charAt()
            char lastSymbol = builder.charAt(builder.length() - 1);
            // Проходимся по всем словам из списка
            for (String newWord : list) {
                // Сравниваем последний символ последнего слова с первым символом нового слова из списка.
                // Если мы нашли такое слово, то по заданию добавляем его в StringBuilder с помощью метода append()
                // и не забываем удалить это слово из списка. При этом isAppend станет равной true (в данном случае
                // метод remove() вернёт true при успешном удалении слова из списка)
                if (newWord.charAt(0) == lastSymbol) {
                    builder.append(" ").append(newWord);
                    isAppend = list.remove(newWord);
                    break;
                }
            }
            // Если в цикле for мы не нашли подходящего слова, то просто добавим в StringBuilder первое слово из списка
            // методом remove(), чтобы сразу удалить его
            if (!isAppend) {
                builder.append(" ").append(list.remove(0));
            }
        }

        return builder.toString();
    }

    private static void task_6() throws IOException {
        // Считываем путь к файлу со словами (нужно ввести: src/res.txt)
        String path = scanner.next();
        // Считываем строку со словами из данного файла с помощью метода Files.readString(), передавая в качестве
        // параметра путь к файлу (путь к файлу из типа String приводим к типу Path с помощью метода Path.of()).
        String s = Files.readString(Path.of(path));
        // Запускаем метод getLine() по заданию и выводим результат работы этого метода.
        System.out.println(getLine(s));
    }
}
