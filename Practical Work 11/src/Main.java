import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        task_1();
    }

    private static void task_1() {
        String str = "Привет! Я люблю программировать на Java!!!";
        Pattern pattern = Pattern.compile(".+?(\\s|$)");
        Matcher matcher = pattern.matcher(str);
        List<String> words = new LinkedList<>();
        while (matcher.find()) {
            words.add(str.substring(matcher.start(), matcher.end()));
        }
        words.forEach(System.out::println);
    }

    private static void task_2() {
        String str1 = "abcdefghijklmnopqrstuv18340";
        String str2 = "abcdefghijklmnoasdfasdpqrstuv18340";
        Pattern pattern = Pattern.compile("abcdefghijklmnopqrstuv18340");
        Matcher matcher = pattern.matcher(str1);
        System.out.println(matcher.find() && matcher.start() == 0 && matcher.end() == str1.length() ? "Является!" : "Не является!");
        matcher = pattern.matcher(str2);
        System.out.println(matcher.find() && matcher.start() == 0 && matcher.end() == str2.length() ? "Является!" : "Не является!");
    }

    private static void task_3() {
        Pattern pattern = Pattern.compile("\\d+?\\.?\\d+?\\s(USD|RUB|EU)");
        String str = scanner.nextLine();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(str.substring(matcher.start(), matcher.end()));
        }
    }

    private static void task_4() {
        String str = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d+?\\s?\\+");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
    }

    private static void task_5() {
        String str = scanner.nextLine();
        Pattern pattern = Pattern.compile("((" +
                "((0[1-9]|[12]\\d|3[01])/(0[13578]|10|12))|" +              // месяцы, в которых 31 день
                "((0[1-9]|[12]\\d|30)/(0[469]|11))|" +                      // месяцы, в которых 30 дней
                "((0[1-9]|1\\d|2[0-8])/02))" +                              // феврали в НЕвисокосных годах
                "/(19|([2-9]\\d))\\d\\d)|" +                                // года с 1900 по 9999
                "((0[1-9]|1\\d|2[0-9])/02/(19|([2-9]\\d))[02468][048])");   // феврали в високосные года
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
    }

    private static void task_6() {
        String str = scanner.nextLine();
        Pattern pattern = Pattern.compile(".+@.+\\..+");
        Matcher matcher = pattern.matcher(str);
        System.out.println((matcher.find() && matcher.start() == 0 && matcher.end() == str.length()));
    }

    private static void task_7() {
        String str = scanner.nextLine();
        if(str.length() >= 8) {
            Pattern lowerChar = Pattern.compile("[a-z]");
            Pattern upperChar = Pattern.compile("[A-Z]");
            Pattern digitChar = Pattern.compile("[0-9]");
            System.out.println((lowerChar.matcher(str).find() && upperChar.matcher(str).find() && digitChar.matcher(str).find()));
        } else {
            System.out.println(false);
        }
    }

    private static void filter(Object[] arr, Filter f) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = f.apply(arr[i]);
        }
    }

    private static void task_8() {
        Filter f = new Filter() {
            @Override
            public Object apply(Object o) {
                String s = (String) o;
                s = s.toLowerCase(Locale.ROOT);
                s = s.trim();
                return s;
            }
        };
        String[] arr = {
                " ASDASDAS ",
                "    AAA",
                " aSDasdas       "
        };
        filter(arr, f);
        for(String s : arr) {
            System.out.println(s);
        }
    }

    private static void task_9() throws IOException {
        String[] words = Files.readString(Path.of("src/res.txt")).toLowerCase(Locale.ROOT).replaceAll("[!?\\.\",:()-]", "").split(" ");
        Map<String, Integer> dictionary = new TreeMap<>();
        for(String word : words) {
            if(dictionary.containsKey(word)) {
                dictionary.put(word, dictionary.get(word) + 1);
            } else {
                dictionary.put(word, 1);
            }
        }
        dictionary.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
