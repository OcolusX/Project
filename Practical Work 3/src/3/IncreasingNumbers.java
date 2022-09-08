public class IncreasingNumbers {
    public static void main(String[] args) {
        int[] arr = new int[4];
        int previous = 100;
        boolean increasing = true;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 90 + 10);
            System.out.print(arr[i] + " ");
            if(arr[i] < previous) {
                increasing = false;
                previous = arr[i];
            }
        }
        System.out.println("\n" + increasing);

    }
}