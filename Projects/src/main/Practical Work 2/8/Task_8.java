public class Task_8 {

    public static void reverse(String[] arr) {
        String t;
        for (int i = 0; i < arr.length / 2; i++) {
            t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5"};
        reverse(arr);
        for(String s : arr) {
            System.out.println(s);
        }
    }
}
