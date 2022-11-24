import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

    private String code;
    private String region;
    private String first;
    private String second;

    // Если номер начинается с +, то код будет +[первая цифра]
    // Если же номер начинается с цифры 8, то код будет +7
    public PhoneNumber(String phoneNumber) {
        if(phoneNumber.startsWith("+")) {
            code = phoneNumber.substring(0, 2);
            region = phoneNumber.substring(2, 5);
            first = phoneNumber.substring(5, 8);
            second = phoneNumber.substring(8);
        } else {
            code = "+7";
            region = phoneNumber.substring(1, 4);
            first = phoneNumber.substring(4, 7);
            second = phoneNumber.substring(7);
        }
    }

    @Override
    public String toString() {
        return code + region + "-" + first + "-" + second;
    }
}
